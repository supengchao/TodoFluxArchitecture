/*
 * ActionDispatcher      2016-04-19
 *
 */
package com.farseer.todo.flux.dispatcher;

import com.farseer.todo.flux.tool.LogTool;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * class description here
 *
 * @author zhaosc
 * @version 1.0.0
 * @since 2016-04-19
 */
public class ActionDispatcher extends Bus {

    public ActionDispatcher() {
        super(ThreadEnforcer.MAIN);
        LogTool.debug("构造 ActionDispatcher");
    }
}