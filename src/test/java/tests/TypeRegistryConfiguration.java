package tests;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterByTypeTransformer;
import io.cucumber.cucumberexpressions.ParameterType;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class TypeRegistryConfiguration implements ParameterByTypeTransformer, TypeRegistryConfigurer {
    @Override
    public Locale locale() {
        return new Locale("RU");
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineParameterType(new ParameterType<>("stringList", ".+", List.class,
                this::transformStrings
        ));
    }
    private List<String> transformStrings(String integers) {
        List<String> stringList = Arrays.asList(integers.split(","));
        return stringList.stream().map(String::trim).collect(Collectors.toList());
    }

    @Override
    public Object transform(String s, Type type) throws Throwable {
        return new Object();
    }
}
