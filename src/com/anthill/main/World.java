
package com.anthill.main;

import com.spartanlaboratories.engine.game.Alive;
import com.spartanlaboratories.engine.structure.Controller;
import com.spartanlaboratories.engine.structure.DynamicCamera;
import com.spartanlaboratories.engine.structure.Engine;
import com.spartanlaboratories.engine.structure.Human;
import com.spartanlaboratories.engine.structure.Map;
import com.spartanlaboratories.engine.util.Location;

public class World extends Map{

	public World(Engine engine) {
		super(engine);
	}

	@Override
	public void init() {
		super.init();
	}
	@Override
	protected void update() {}
	protected void playerStartAction(Controller controller) {
		Alive dwarf = new Alive(engine, Alive.Faction.RADIANT);
		controller.addUnit(dwarf);
		dwarf.setTexture("res/ant.jpg");
		dwarf.setSize(40,40);
		dwarf.setColor("white");
		dwarf.setLocation(new Location(0,0));
		
		if(!Human.class.isAssignableFrom(controller.getClass()))return;

		Human human = (Human)controller;
		DynamicCamera camera = new DynamicCamera(engine, human.getScreenSize());
		human.addCamera(camera);
		camera.pan.setPanningRange(60);
		camera.pan.setCameraSpeed(20);
		camera.pan.setCameraAcceleration(1);
		camera.zoom.holdPointOnZoom(true);
		
		human.notifyClient("load texture");
		human.notifyClient("res/ant.jpg");
	}
	
}
