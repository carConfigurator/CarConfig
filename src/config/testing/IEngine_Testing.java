package config.testing;

import daoImpl.EngineDAO_XML;
import idao.IEngine;
import model.Engine;

public class IEngine_Testing {

	public static void main(String[] args) {
		IEngine iengine = new EngineDAO_XML();
		Engine engine = iengine.getEngine(0);
		System.out.println(engine.toString());
	}
	
}
