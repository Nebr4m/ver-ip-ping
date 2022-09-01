package view;

import javax.swing.JOptionPane;
import controller.RedesController;

public class Main {
	static String qualSO;

	public static void main(String[] args) {


		int opc = 0;
		String processo = null;
		RedesController controller = new RedesController();

		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1- sistema operacional\n2- checar ip \n3- teste ping\n9- fechar"));
			switch (opc) {

			case 1:
				qualSO = sistema(qualSO);
				System.out.println(qualSO);
				break;
			case 2:
				if (qualSO.contains("Windows")) {
					processo = "IPCONFIG";
				} 	else {
					processo = "ifconfig";
				}
				controller.IP(processo,qualSO);

				break;
			case 3:
				if (qualSO.contains("Windows")) {
				processo = "PING -4 -n 10 www.google.com.br";
				}	else {
				processo="ping -4 -c 10 www.google.com.br"; 
				}
				controller.Ping(processo,qualSO);
				break;

			case 9:
				System.exit(0);
			default:
				JOptionPane.showMessageDialog(null, "opçao invalida");
				break;
			}
		}

	}

	private static String sistema(String os) {

		os = System.getProperty("os.name");
		return os;
	}
}
