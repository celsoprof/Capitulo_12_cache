package br.com.fiap.receitasapp.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.receitasapp.data.local.dao.ReceitaDao
import br.com.fiap.receitasapp.data.local.entity.ReceitaEntity

@Database(entities = [ReceitaEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun receitaDao(): ReceitaDao

    companion object {
        private lateinit var instance: AppDatabase

        fun getDatabase(context: Context): AppDatabase {
            if (!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(
                        context = context,
                        klass = AppDatabase::class.java,
                        name = "receitas"
                    )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }

}