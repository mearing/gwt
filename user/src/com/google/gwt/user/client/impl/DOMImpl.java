/*
 * Copyright 2008 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.user.client.impl;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;

/**
 * Native implementation associated with {@link com.google.gwt.user.client.DOM}.
 */
public abstract class DOMImpl {

  protected static boolean eventSystemIsInitialized;

  /**
   * Returns <code>true</code>if the object is an instance of EventListener
   * and the object belongs to this module.
   */
  protected static boolean isMyListener(Object object) {
    /*
     * The first test ensures the Object belongs to this module in web mode by
     * ensuring this is not a JavaScriptObject. In web mode, foreign Java
     * objects appear to be JavaScriptObject. See Cast.isJavaScriptObject().
     * 
     * The second test then checks the exact type.
     * 
     * TODO: make the generated code smaller!
     */
    return !(object instanceof JavaScriptObject)
        && (object instanceof com.google.gwt.user.client.EventListener);
  }

  public native void eventCancelBubble(Event evt, boolean cancel) /*-{
    evt.cancelBubble = cancel;
   }-*/;

  public native boolean eventGetAltKey(Event evt) /*-{
    return !!evt.altKey;
   }-*/;

  public native int eventGetButton(Event evt) /*-{
    return evt.button || 0;
   }-*/;

  public native int eventGetClientX(Event evt) /*-{
    return evt.clientX || 0;
   }-*/;

  public native int eventGetClientY(Event evt) /*-{
    return evt.clientY || 0;
   }-*/;

  public native boolean eventGetCtrlKey(Event evt) /*-{
    return !!evt.ctrlKey;
   }-*/;

  public native Element eventGetCurrentTarget(Event evt) /*-{
    return evt.currentTarget;
   }-*/;

  public abstract Element eventGetFromElement(Event evt);

  public native int eventGetKeyCode(Event evt) /*-{
    // 'which' gives the right key value, except when it doesn't -- in which
    // case, keyCode gives the right value on all browsers.
    // If all else fails, return an error code
    return evt.which || evt.keyCode || 0;
   }-*/;

  public native boolean eventGetMetaKey(Event evt) /*-{
    return !!evt.metaKey;
   }-*/;

  public abstract int eventGetMouseWheelVelocityY(Event evt);

  public native boolean eventGetRepeat(Event evt) /*-{
    return !!evt.repeat;
   }-*/;

  public native int eventGetScreenX(Event evt) /*-{
    return evt.screenX || 0;
   }-*/;

  public native int eventGetScreenY(Event evt) /*-{
    return evt.screenY || 0;
   }-*/;

  public native boolean eventGetShiftKey(Event evt) /*-{
    return !!evt.shiftKey;
   }-*/;

  public abstract Element eventGetTarget(Event evt);

  public abstract Element eventGetToElement(Event evt);

  public native String eventGetType(Event evt) /*-{
    return evt.type;
   }-*/;

  public native int eventGetTypeInt(Event evt) /*-{
      switch (evt.type) {
        case "blur": return 0x01000;
        case "change": return 0x00400;
        case "click": return 0x00001;
        case "dblclick": return 0x00002;
        case "focus": return 0x00800;
        case "keydown": return 0x00080;
        case "keypress": return 0x00100;
        case "keyup": return 0x00200;
        case "load": return 0x08000;
        case "losecapture": return 0x02000;
        case "mousedown": return 0x00004;
        case "mousemove": return 0x00040;
        case "mouseout": return 0x00020;
        case "mouseover": return 0x00010;
        case "mouseup": return 0x00008;
        case "scroll": return 0x04000;
        case "error": return 0x10000;
        case "mousewheel": return 0x20000;
        case "DOMMouseScroll": return 0x20000;
        case "contextmenu": return 0x40000;
      }
    }-*/;

  public abstract void eventPreventDefault(Event evt);

  public native void eventSetKeyCode(Event evt, char key) /*-{
      evt.keyCode = key;
    }-*/;

  public abstract String eventToString(Event evt);

  public abstract Element getChild(Element elem, int index);

  public abstract int getChildCount(Element elem);

  public abstract int getChildIndex(Element parent, Element child);

  public native int getEventsSunk(Element elem) /*-{
      return elem.__eventBits || 0;
    }-*/;

  public abstract void insertChild(Element parent, Element child, int index);

  public void maybeInitializeEventSystem() {
    if (!eventSystemIsInitialized) {
      initEventSystem();
      eventSystemIsInitialized = true;
    }
  }

  public abstract void releaseCapture(Element elem);

  public abstract void setCapture(Element elem);

  public native void setEventListener(Element elem, EventListener listener) /*-{
      elem.__listener = listener;
    }-*/;

  public abstract void sinkEvents(Element elem, int eventBits);

  /**
   * Initializes the event dispatch system.
   */
  protected abstract void initEventSystem();
}
