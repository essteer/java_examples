package com.kodnito.resources;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")  // identifies app path that will serve as base for all endpoints
public class ApplicationConfig extends Application {

}