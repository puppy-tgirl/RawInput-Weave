package me.nyaaa.rawinput.listener

import me.nyaaa.rawinput.mouses
import net.java.games.input.Controller
import net.java.games.input.ControllerEvent
import net.java.games.input.ControllerListener
import net.java.games.input.Mouse

class MouseListener : ControllerListener {
    override fun controllerAdded(event: ControllerEvent) {
        if (event.controller.type == Controller.Type.MOUSE) {
            mouses.add(event.controller as Mouse)
            println("[Raw Input] Mouse added. ${event.controller.name}")
        }
    }

    override fun controllerRemoved(event: ControllerEvent) {
        if (mouses.contains(event.controller)) {
            mouses.remove(event.controller)
            println("[Raw Input] Mouse removed. ${event.controller.name}")
        }
    }
}