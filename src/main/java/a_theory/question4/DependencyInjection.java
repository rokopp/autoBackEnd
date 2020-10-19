package a_theory.question4;

public class DependencyInjection {

    //todo
    // One of the reasons we use Spring is that it gives us good support for
    // Dependency Injection (DI) and Inversion of Control (IoC)

    //todo p1
    // In your words (do not use wiki definitions)
    // What is Dependency Injection?
    // Answer: Alternatively making up objects yourself, you could ask "someone" to give you an instance. You will be
    // using them as a cleaner alternative to global or static data.

    //todo p2
    // Bring example from your code of Dependency Injection.
    // Paste your code here, but comment it out

    /*
    @Entity
    @Getter @Setter @NoArgsConstructor @Builder
    @AllArgsConstructor
    public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String userName;

    private String password;

    @Column(unique=true)
    private String email;

    private String phoneNumber;

    @OneToMany(mappedBy = "account", cascade = {CascadeType.ALL})
    @JsonIgnore
    private List<Advertisement> advertisements;
}

     */

    //todo p3
    // Name 2 benefits of Dependency Injection
    // 1 You save time and trouble writing extra code. Which means code easier to read.
    // 2 Human errors are limited to almost none.

    //todo p4
    // Name 1 disadvantage of Dependency Injection
    // 1 It's harder to understand how a class works when reading just that class.
    // You may have to track down its invocation to see what kind of components are passed in.
    // source: https://gist.github.com/r00k/3105024
}
