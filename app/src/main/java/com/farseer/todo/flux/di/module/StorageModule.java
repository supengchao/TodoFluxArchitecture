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

package com.farseer.todo.flux.di.module;

import android.app.Application;
import android.database.sqlite.SQLiteOpenHelper;
import com.farseer.todo.flux.BuildConfig;
import com.farseer.todo.flux.database.DatabaseOpenHelper;
import com.farseer.todo.flux.tool.LogTool;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;
import dagger.Module;
import dagger.Provides;

/**
 * Storage Module
 *
 * @author zhaosc
 * @version 1.0.0
 * @since 2016-04-18
 */
@Module
public class StorageModule {

    private Application application;
    private String userId;

    /**
     * 构造StorageModule.
     *
     * @param application application
     * @param userId      用户id
     */
    public StorageModule(Application application, String userId) {
        this.application = application;
        this.userId = userId;
    }

    /**
     * 提供BriteDatabase注入.
     *
     * @return BriteDatabase
     */
    @Provides
    BriteDatabase briteDatabase() {
        SqlBrite sqlBrite = SqlBrite.create(message -> LogTool.debug("Database", message));

        SQLiteOpenHelper sqLiteOpenHelper = new DatabaseOpenHelper(application, userId);
        BriteDatabase db = sqlBrite.wrapDatabaseHelper(sqLiteOpenHelper);
        db.setLoggingEnabled(BuildConfig.DEBUG);
        return db;
    }
}
