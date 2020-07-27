(ns demo.desktop-launcher
  (:require [demo.core :refer :all])
  (:import [com.badlogic.gdx.backends.lwjgl LwjglApplication])
  (:gen-class))

(defn -main []
  (LwjglApplication. (demo.core.Game.) "demo" 800 600))
