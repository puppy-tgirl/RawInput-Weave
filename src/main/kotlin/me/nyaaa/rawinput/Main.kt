package me.nyaaa.rawinput

import me.nyaaa.rawinput.listener.MouseListener
import net.java.games.input.ControllerEnvironment
import net.java.games.input.Mouse
import net.weavemc.loader.api.ModInitializer
import net.weavemc.loader.api.event.EventBus
import net.weavemc.loader.api.event.StartGameEvent

val environ: ControllerEnvironment = ControllerEnvironment.getDefaultEnvironment()
var mouses: MutableList<Mouse> = environ.controllers.filterIsInstance<Mouse>().toMutableList()

class Main : ModInitializer {
    override fun preInit() {
        EventBus.subscribe(StartGameEvent.Post::class.java) {
            environ.addControllerListener(MouseListener())
            println("[Raw Input] Mouse listener added.")
        }
    }
}