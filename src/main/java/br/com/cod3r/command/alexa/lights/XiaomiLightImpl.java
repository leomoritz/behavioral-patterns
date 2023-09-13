package br.com.cod3r.command.alexa.lights;

public class XiaomiLightImpl implements GenericLight {

	@Override
	public void turnOn() {
		System.out.println("The XiaomiLight is On");
	}

	@Override
	public void turnOff() {
		System.out.println("The XiaomiLight is Off");
	}
}
