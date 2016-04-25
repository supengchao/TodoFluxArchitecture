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

package com.farseer.todo.flux.pojo;

/**
 * Todo事项
 *
 * @author zhaosc
 * @version 1.0.0
 * @since 2016-04-19
 */
public class TodoItem {
    private Long id;
    private String description;
    private boolean isCompleted;
    private boolean isStar;

    public TodoItem(Long id, String description) {
        this(id, description, false, false);
    }

    public TodoItem(Long id, String description, boolean isCompleted) {
        this(id, description, isCompleted, false);
    }

    public TodoItem(Long id, String description, boolean isCompleted, boolean isStar) {
        this.isStar = isStar;
        this.isCompleted = isCompleted;
        this.description = description;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public boolean isStar() {
        return isStar;
    }

    public void setStar(boolean star) {
        isStar = star;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isCompleted=" + isCompleted +
                ", isStar=" + isStar +
                '}';
    }

}