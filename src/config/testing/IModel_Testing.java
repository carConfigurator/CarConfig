package config.testing;

import daoImpl.ModelDAO_XML;
import idao.IModel;
import model.Model;

public class IModel_Testing {

	public static void main(String[] args) {
		IModel imodel = new ModelDAO_XML();
		Model model = imodel.getModel(0);
		System.out.println(model.toString());
	}
	
}
