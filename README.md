## GWT method reference bug

This compilation works 

    mvn clean package -Dgwt.optimize=1
    
This compilation does NOT work

    mvn clean package -Dgwt.optimize=0
    
Project structure is based on https://github.com/ibaca/gwt-instantiable-inference-bug
