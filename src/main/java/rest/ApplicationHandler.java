package rest;

import Constants.ApplicationHandlerConstanst;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


/**
 * Created by Florian on 13.06.2017.
 * Legt fest welche Arten von Resourcen an den Server weiter gegeben werden
 * wenn keine Resourcen angebeben sind == Klasse leer -> Per default: alle
 * Path: /webapi
 */

@ApplicationPath(ApplicationHandlerConstanst.APPLICATION_PATH)
public class ApplicationHandler extends Application {
}
