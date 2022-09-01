package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	public RedesController() {

		super();
	}

	@SuppressWarnings("deprecation")
	public void IP(String processo, String qualSO) {

		try {
			Process a = Runtime.getRuntime().exec(processo);
			InputStream fluxo = a.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				if (qualSO.equals("Windows 10")) {
					if (linha.contains("IPv4")) {
						String[] vetor = linha.split(": ");
						System.out.println("IPv4: " + vetor[1]);
					}

				}
				if (qualSO.equals("Linux")) {
					if (linha.contains("inet")) {
						String vet[] = linha.trim().split(" ");
						if (vet[0].equals("inet")) {
							System.out.println(vet[1]);
						}
					}
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void Ping(String processo, String qualSO) {

		try {
			@SuppressWarnings("deprecation")
			Process b = Runtime.getRuntime().exec(processo);
			InputStream fluxo = b.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				if (qualSO.equals("Windows 10")) {
					if (linha.contains("dia")) {
						String[] vetor = linha.split("= ");
						System.out.println(vetor[3]);

					}
				}
				if (qualSO.equals("Linux")) {
					if (linha.contains("mdev")) {
						String vet1[] = linha.trim().split("=");
						String vet2[] = vet1[1].trim().split("/");
						System.out.println(vet2[1] + " ms");

					}
				}
				linha = buffer.readLine();
			}

			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

