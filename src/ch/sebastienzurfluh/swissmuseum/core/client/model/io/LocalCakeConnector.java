package ch.sebastienzurfluh.swissmuseum.core.client.model.io;

/**
 * This is a simple CakeConnector with a local host.
 *
 *
 * @author Sebastien Zurfluh
 *
 */
public class LocalCakeConnector extends CakeConnector {
	public LocalCakeConnector() {
		super("http://192.168.50.62/SwissMuseumParcours/CakePHPv2/index.php/");
	}
}
