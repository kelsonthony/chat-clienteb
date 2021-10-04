package com.kelsonthony.chat.cliente.thread;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

import com.kelsonthony.chat.cliente.gui.JanelaGui;

public class RecebeMensagemDoServidor implements Runnable {

	private Socket socket;
	private JanelaGui janela;
	
	
	
	public RecebeMensagemDoServidor(Socket socket, JanelaGui janela) {
		super();
		this.socket = socket;
		this.janela = janela;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				InputStream is = this.socket.getInputStream();
				DataInput dis = new DataInputStream(is);
				String msgRecebido = dis.readUTF();
				
				janela.adicionaMensagem(msgRecebido);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
