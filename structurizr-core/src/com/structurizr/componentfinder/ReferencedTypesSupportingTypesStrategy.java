package com.structurizr.componentfinder;

import com.structurizr.model.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * This strategy finds all types that are referenced by the component type
 * and supporting types.
 */
public class ReferencedTypesSupportingTypesStrategy extends SupportingTypesStrategy {

    @Override
    public Set<String> getSupportingTypes(Component component) throws Exception {
        Set<String> set = new HashSet<>();
        set.addAll(componentFinderStrategy.getReferencedTypesInPackage(component.getType()));

        for (String supportingType : component.getSupportingTypes()) {
            set.addAll(componentFinderStrategy.getReferencedTypesInPackage(supportingType));
        }

        return set;
    }

}
