package com.example.catprod.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Categoria::class, Producto::class],
    version = 1
)
abstract class TiendaDb : RoomDatabase() {

    abstract  fun TiendaDAO():TiendaDAO

    companion object{
        @Volatile
        private var INSTANCE:TiendaDb? = null

        fun getDatabase(context: Context):TiendaDb{
            val instance = INSTANCE
            if (instance != null){
                return instance
            }

            synchronized(this){
                val newInstance = Room.databaseBuilder(
                    context.applicationContext,
                    TiendaDb::class.java,
                    "TiendaDb"
                ).build()
                INSTANCE = newInstance
                return newInstance
            }




        }
    }


}