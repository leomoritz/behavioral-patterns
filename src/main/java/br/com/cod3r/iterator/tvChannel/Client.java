package br.com.cod3r.iterator.tvChannel;

public class Client {

	public static void main(String[] args) {
		TV tv = new TV();
		tv.searchAvaiableChannels();

		/*
		Percorrendo antes do padrão
		for(int i = 1; i < 30; i++) {
			tv.accessChannel(i);
		}*/

		// Percorrendo os canais após aplicar o padrão
		for(int channel : tv) {
			System.out.println(String.format("Zapping at channel #%d", channel));
		}
	}
}
