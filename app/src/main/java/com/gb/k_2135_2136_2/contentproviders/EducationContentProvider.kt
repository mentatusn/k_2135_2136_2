package com.gb.k_2135_2136_2.contentproviders

import android.content.ContentProvider
import android.content.ContentUris
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import androidx.lifecycle.Transformations.map
import com.gb.k_2135_2136_2.MyApp.Companion.getWeatherDatabase
import com.gb.k_2135_2136_2.R
import com.gb.k_2135_2136_2.model.room.WeatherEntity
import com.gb.k_2135_2136_2.utils.ID
import com.gb.k_2135_2136_2.utils.NAME
import com.gb.k_2135_2136_2.utils.TEMPERATURE

private const val URI_ALL = 1 // URI для всех записей
private const val URI_ID = 2 // URI для конкретной записи
private const val ENTITY_PATH ="weather_entity_table" // Часть пути (будем определять путь до WeatherEntity)


class EducationContentProvider:ContentProvider() {

    private var authorities: String? = null // Адрес URI
    private lateinit var uriMatcher: UriMatcher // Помогает определить тип адреса URI

    // Типы данных
    private var entityContentType: String? = null // Набор строк
    private var entityContentItemType: String? = null // Одна строка

    private lateinit var contentUri: Uri // Адрес URI Provider

    private val weatherDAO by lazy {
        getWeatherDatabase().weatherDao()
    }

    override fun onCreate(): Boolean {
        context?.let {
            authorities = it.resources.getString(R.string.authorities)
            uriMatcher = UriMatcher(UriMatcher.NO_MATCH)
            uriMatcher.addURI(authorities,ENTITY_PATH,URI_ALL)
            uriMatcher.addURI(authorities,"$ENTITY_PATH/#",URI_ID)
            entityContentType = "vnd.android.cursor.dir/vnd.$authorities.$ENTITY_PATH"
            // Тип содержимого — один объект
            entityContentItemType = "vnd.android.cursor.item/vnd.$authorities.$ENTITY_PATH"
            // Строка для доступа к Provider

            contentUri = Uri.parse("content://${authorities}/${ENTITY_PATH}")
        }
        return true
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor {
        val responseCursor = when( uriMatcher.match(uri)){
            URI_ALL->{
                weatherDAO.getWeatherCursor()
            }
            URI_ID->{
                val id = ContentUris.parseId(uri)
                weatherDAO.getWeatherCursor(id)
            }
            else -> {throw IllegalStateException("BAD query")}
        }
        responseCursor.setNotificationUri(context!!.contentResolver,contentUri) // на данном этапе в этой строке мало смысла
        return responseCursor
    }

    override fun getType(uri: Uri): String? {
        return when( uriMatcher.match(uri)){
            URI_ALL->{
                entityContentType
            }
            URI_ID->{
                entityContentItemType
            }
            else -> {throw IllegalStateException("BAD query")}
        }
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        val weather = mapperRawToWeatherEntity(values)
        weatherDAO.insertRoom(weather)
        context!!.contentResolver.notifyChange(
            contentUri,
            null
        )
        return ContentUris.withAppendedId(contentUri, weather.id)
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        val weatherDAO = getWeatherDatabase().weatherDao()
        val id = ContentUris.parseId(uri)
        weatherDAO.deleteById(id)
        context!!.contentResolver.notifyChange(
            contentUri,
            null
        )
        return 1
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        weatherDAO.updateRoom(mapperRawToWeatherEntity(values))
        context!!.contentResolver.notifyChange(
            contentUri,
            null
        )
        return 1
    }

    // Переводим ContentValues в HistoryEntity
    private fun mapperRawToWeatherEntity(values: ContentValues?): WeatherEntity {
        return if (values == null) {
            WeatherEntity()
        } else {
            val id = if (values.containsKey(ID)) values[ID] as Long else 0
            val name = values[NAME] as String
            val temperature = values[TEMPERATURE] as Int
            WeatherEntity(id=id, name, temperature=temperature)
        }
    }


}