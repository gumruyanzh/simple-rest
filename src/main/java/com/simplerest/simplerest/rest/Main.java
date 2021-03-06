package com.simplerest.simplerest.rest;

import com.simplerest.simplerest.rest.api.EmployeeResource;

import com.simplerest.simplerest.rest.api.HelloWorldEndpoint;
import com.simplerest.simplerest.rest.api.MyResource;
import com.simplerest.simplerest.rest.api.UserEndpoint;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.datasources.DatasourcesFraction;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

public class Main {

    public static void main(String[] args) throws Exception {

        Swarm swarm = new Swarm();
        //String useDB = System.getProperty("swarm.use.db", "mysql");
        swarm.fraction(datasourceWithMysql());


        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);
        deployment.addResource(HelloWorldEndpoint.class);
        deployment.addResource(MyResource.class);
        deployment.addResource(EmployeeResource.class);
        deployment.addResource(UserEndpoint.class);

        // WEB Resources
        deployment.addAsWebInfResource(
                new ClassLoaderAsset("META-INF/persistence.xml", Main.class.getClassLoader()), "classes/META-INF/persistence.xml");

        deployment.addAsWebInfResource(
                new ClassLoaderAsset("META-INF/beans.xml", Main.class.getClassLoader()), "beans.xml");
        deployment.addAllDependencies();
        deployment.addPackage("com.simplerest.simplerest.rest");
        deployment.addPackage("com.simplerest.simplerest.rest.entity");
        deployment.addPackage("com.simplerest.simplerest.rest.api");
        deployment.addPackage("com.simplerest.simplerest.rest.service");

        deployment.addPackage("com.simplerest.simplerest.rest.jwt");
        deployment.addPackage("com.simplerest.simplerest.rest.util");

        swarm.start().deploy(deployment);
    }


    private static DatasourcesFraction datasourceWithMysql() {
        return new DatasourcesFraction()
                .jdbcDriver("com.mysql", (d) -> {
                    d.driverClassName("com.mysql.cj.jdbc.Driver");
                    d.xaDatasourceClass("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
                    d.driverModuleName("com.mysql");
                })
                .dataSource("ExampleDS", (ds) -> {
                    ds.driverName("com.mysql");
                    ds.connectionUrl("jdbc:mysql://localhost:3306/swarm?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
                    ds.userName("root");
                    ds.password("root");
                });
    }
}
