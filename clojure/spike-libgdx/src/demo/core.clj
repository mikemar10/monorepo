(ns demo.core
  (:require [demo.mike :refer :all])
	(:import [com.badlogic.gdx Game Gdx Graphics Screen]
					 [com.badlogic.gdx.graphics Color GL20]
					 [com.badlogic.gdx.graphics.g2d BitmapFont]
					 [com.badlogic.gdx.scenes.scene2d Stage]
					 [com.badlogic.gdx.scenes.scene2d.ui Label Label$LabelStyle]))

(gen-class
	:name demo.core.Game
	:extends com.badlogic.gdx.Game)

(defn label-factory [style]
  (Label. (get-string) style))

(def main-screen
	(let [stage (atom nil)]
		(proxy [Screen] []
			(show []
				(reset! stage (Stage.))
				(let [style (Label$LabelStyle. (BitmapFont.) (Color. 1 1 1 1))
							label (label-factory style)]
					(.addActor @stage label)))
			(render [delta]
				(.glClearColor (Gdx/gl) 0 0 0 0)
				(.glClear (Gdx/gl) GL20/GL_COLOR_BUFFER_BIT)
				(doto @stage
					(.act delta)
					(.draw)))
			(dispose[])
			(hide [])
			(pause [])
			(resize [w h])
			(resume []))))

(defn -create [^Game this]
	(.setScreen this main-screen))
