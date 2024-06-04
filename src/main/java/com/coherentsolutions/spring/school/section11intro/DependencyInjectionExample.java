package com.coherentsolutions.spring.school.section11intro;

public class DependencyInjectionExample {

    interface Repository {
        void performOperation();
    }

    static class SpecificRepository implements Repository {
        @Override
        public void performOperation() {
            System.out.println("Performing operation in SpecificRepository");
        }
    }

    static class ImprovedService {
        private Repository repository;

        public ImprovedService(Repository repository) {
            this.repository = repository;
        }

        public void execute() {
            System.out.println("Executing service operation with Dependency Injection.");
            repository.performOperation();
        }
    }

    public static void main(String[] args) {
        Repository repository = new SpecificRepository();
        ImprovedService service = new ImprovedService(repository);
        service.execute();
    }
}
