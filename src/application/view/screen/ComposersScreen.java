package application.view.screen;

import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import application.model.entities.Composer;
import application.model.repositories.ComposerRepository;
import application.util.Screen;

public class ComposersScreen {
	public static void view() {
		
		Screen.clear();
		Scanner sc = new Scanner(System.in);
		
		 List<Composer> compositores = ComposerRepository.getAll();
		 
		 if(compositores == null) {
				System.out.println("Nenhum compositor registrado");	
				System.out.println();
				System.out.println("Pressione Enter para retornar ao menu principal.");
				sc.nextLine();
		 } else {
			ListIterator<Composer> it = compositores.listIterator();
			
			System.out.println("Compositores: ");
			System.out.println();
			
			while(it.hasNext()) {
				for(int i = 0; i < compositores.size(); i++) {
					System.out.println(it.next().toString());
					System.out.println();
				}
				
				System.out.println("Pressione Enter para Continuar.");
				sc.nextLine();		
	}
}
}
}