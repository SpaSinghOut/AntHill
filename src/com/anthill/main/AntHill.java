
package com.anthill.main;

import com.spartanlaboratories.engine.structure.Engine;

public class AntHill {
	public static void main(String[] args){
		Engine engine = new Engine();
		engine.goMulti(new World(engine), 1);
		engine.tracker.initialize();
		engine.run();
	}
}
