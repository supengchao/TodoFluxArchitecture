/*
 *
 *    Copyright 2016 zhaosc
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.farseer.todo.flux.database;

import com.farseer.todo.flux.tool.LogTool;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zhaosc on 16/4/23.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context, String databaseName) {
        super(context, databaseName, null, DatabaseSQL.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.beginTransaction();
        try {
            for (int i = 0; i < DatabaseSQL.SQL_ALL.length; i++) {
                String[] tmp = DatabaseSQL.SQL_ALL[i];
                for (int j = 0; j < tmp.length; j++) {
                    db.execSQL(tmp[j]);
                }
            }
            db.setTransactionSuccessful();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }

        LogTool.debug("DatabaseHelper.onCreate finish");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.beginTransaction();
        try {
            for (int i = oldVersion; i < DatabaseSQL.SQL_ALL.length; i++) {
                String[] tmp = DatabaseSQL.SQL_ALL[i];
                for (int j = 0; j < tmp.length; j++) {
                    db.execSQL(tmp[j]);
                }
            }
            db.setTransactionSuccessful();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }

        LogTool.debug("DatabaseHelper.onUpgrade finish");

    }
}
