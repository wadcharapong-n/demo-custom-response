package com.north.democustomerresponse.archunit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "com.north.democustomerresponse", importOptions = {ImportOption.DoNotIncludeTests.class})
public class LayeredArchitectureTest {

    private static final String PACKAGE_ROOT = "com.north.democustomerresponse";
    private static final String PACKAGE_CONTROLLER = PACKAGE_ROOT + ".controller";
    private static final String PACKAGE_SERVICE = PACKAGE_ROOT + ".service";
    private static final String PACKAGE_REPOSITORY = PACKAGE_ROOT + ".repo";

    @ArchTest
    static final ArchRule controllers_should_not_be_accessed_by_other_layers =
            noClasses().that().resideOutsideOfPackages(PACKAGE_CONTROLLER)
                    .should().dependOnClassesThat().resideInAnyPackage(PACKAGE_CONTROLLER);

    @ArchTest
    static final ArchRule services_should_only_be_accessed_by_controllers_or_other_services =
            noClasses().that().resideOutsideOfPackages(PACKAGE_CONTROLLER, PACKAGE_SERVICE)
                    .should().dependOnClassesThat().resideInAnyPackage(PACKAGE_SERVICE);

    @ArchTest
    static final ArchRule repositories_should_only_be_accessed_by_services =
            noClasses().that().resideOutsideOfPackages(PACKAGE_SERVICE, PACKAGE_REPOSITORY)
                    .should().dependOnClassesThat().resideInAnyPackage(PACKAGE_REPOSITORY);

    @ArchTest
    static final ArchRule controller_classes_should_end_with_Controller =
            classes().that().resideInAPackage(PACKAGE_CONTROLLER)
                    .should().haveSimpleNameEndingWith("Controller");

    @ArchTest
    static final ArchRule service_classes_should_end_with_Service =
            classes().that().resideInAPackage(PACKAGE_SERVICE)
                    .should().haveSimpleNameEndingWith("Service");

    @ArchTest
    static final ArchRule repository_classes_should_end_with_Repository =
            classes().that().resideInAPackage(PACKAGE_REPOSITORY)
                    .should().haveSimpleNameEndingWith("Repository");

    @ArchTest
    static final ArchRule controllers_should_be_annotated_with_RestController =
            classes().that().resideInAPackage(PACKAGE_CONTROLLER)
                    .should().beAnnotatedWith(org.springframework.web.bind.annotation.RestController.class);

    @ArchTest
    static final ArchRule controllers_should_be_annotated_with_RequestMapping =
            classes().that().resideInAPackage(PACKAGE_CONTROLLER)
                    .should().beAnnotatedWith(org.springframework.web.bind.annotation.RequestMapping.class);


}
