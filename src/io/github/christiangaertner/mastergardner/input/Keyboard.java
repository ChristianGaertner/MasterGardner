/*
 * Keyboard Input Getter
 * 
 */
package io.github.christiangaertner.mastergardner.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Christian
 */
public class Keyboard implements KeyListener {

    private String lastKey;
    private int maxKeyCount = 65536;
    private boolean[] keyLatched = new boolean[maxKeyCount];
    private boolean[] keyDown = new boolean[maxKeyCount];
    private String[] keyNames;
    private Map<String, Integer> keyCodeMap;

    public Keyboard() {
        keyCodeMap = new HashMap<String, Integer>();
        initKeys();
    }

    public boolean isKeyDown(int key) {
        boolean r = keyDown[key] || keyLatched[key];
        keyLatched[key] = false;
        return r;
    }

    public boolean isKeyDown(String key) {
        Integer code = keyCodeMap.get(key);
        if (code != null) {
            return isKeyDown(code);
        } else if (key.codePointCount(0, key.length()) == 1) {
            int keyChar = key.codePointAt(0);
            keyChar = Character.toUpperCase(keyChar);
            return isKeyDown(keyChar);
        } else {
            return false;
        }
    }

    public synchronized String getKey() {
        String r = lastKey;
        lastKey = null; //Reset it
        return r;
    }

    public void addKey(String name, int code) {
        keyCodeMap.put(name, code);
    }

    private void initKeys() {
        addKey("up", KeyEvent.VK_UP);
        addKey("down", KeyEvent.VK_DOWN);
        addKey("left", KeyEvent.VK_LEFT);
        addKey("right", KeyEvent.VK_RIGHT);
        addKey("space", KeyEvent.VK_SPACE);
        addKey("enter", KeyEvent.VK_ENTER);
        addKey("escape", KeyEvent.VK_ESCAPE);
        addKey("shift", KeyEvent.VK_SHIFT);
        addKey("control", KeyEvent.VK_CONTROL);

        keyNames = new String[maxKeyCount];

        Iterator<String> nameIt = keyCodeMap.keySet().iterator();

        while (nameIt.hasNext()) {
            String name = nameIt.next();
            int keyCode = keyCodeMap.get(name);
            keyNames[keyCode] = name;
        }
    }

    private void pressKey(int code) {
        keyLatched[code] = true;
        keyDown[code] = true;
    }

    private void releaseKey(int code) {
        keyDown[code] = false;
        if (code < maxKeyCount) {
            String keyName = keyNames[code];
            if (keyName != null) {
                lastKey = keyName;
            }
        }
    }

    /**
     *
     * @param ke
     */
    @Override
    public void keyTyped(KeyEvent ke) {
        char c = ke.getKeyChar();
        if (c == '\n' || c == '\r') {
            lastKey = "enter";
        } else if (c == '\t') {
            lastKey = "tab";
        } else if (c == '\b') {
            lastKey = "backspace";
        } else if (c == ' ') {
            lastKey = "space";
        } else if (c == 27) {
            lastKey = "escape";
        } else {
            lastKey = "" + c;
        }
    }

    /**
     *
     * @param ke
     */
    @Override
    public void keyPressed(KeyEvent ke) {
        int keyCode = ke.getKeyCode();
        pressKey(keyCode);
    }

    /**
     *
     * @param ke
     */
    @Override
    public void keyReleased(KeyEvent ke) {
        int keyCode = ke.getKeyCode();
        releaseKey(keyCode);
    }
}
