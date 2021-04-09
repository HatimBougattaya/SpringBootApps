package presentation;

import dao.DaoImpl;
import dao.Idao;
import metier.Imetier;
import metier.MetierImpl;

import java.io.File;
import java.lang.reflect.Method;
import java.util.*;

public class Pres1 {
	public static void main(String[] args) throws Exception{
		
		//ID par Instanciation statique
		/*
		Idao dao = new DaoImpl();
		MetierImpl m = new MetierImpl();
		m.setDao(dao);
		System.out.println(m.calcul());
		 */
		
		//Instanciation dynamique
		Scanner scanner = new Scanner(new File("config.txt"));
		String daoClassName = scanner.nextLine();
		Class cDao = Class.forName(daoClassName);
		Idao dao = (Idao) cDao.newInstance();
		
		//System.out.println(dao.getValue());
		
		String metierClassName = scanner.nextLine();
		Class cMetier = Class.forName(metierClassName);
		Imetier metier = (Imetier) cMetier.newInstance();
		Method m = cMetier.getMethod("setDao",Idao.class);
		m.invoke(metier, dao);		
		
		System.out.println(metier.calcul());
		
		/*Avec spring il suffit de remplacer le fichier config par un fichier xml
		 et au lieu de preciser les bean à utiliser il suffit d'utiliser les annotations :
		 @Component pour charger l'objet && @Autowired pour l'injection des dependances
		 */
	}
}
