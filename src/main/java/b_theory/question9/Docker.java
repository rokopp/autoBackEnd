package b_theory.question9;

public class Docker {

    //todo A
    // What is a server?
    // Answer: A server in practical terms is any computer that is doing something for another computer.
    // When you visit a web page your computer or phone (the client) is asking another computer (the server) for a page.
    // It builds it and sends it to you. Technically any device is capable of being a server. For example an iPhone is a
    // server to the Apple Watch.

    //todo B
    // What is the difference between build server and production server?
    // Answer: A production server is configured to restrict access to authorized users and to limit control to
    // system administrators.

    //todo C
    // What is docker?
    // Answer: Docker is a container technology that utilizes the host OS's kernel while putting the userland
    // applications into a sandbox. It is more lightweight than a full-fledged virtual machine,
    // but you're applications need to be compatible with the host OS.

    //todo D
    // Name and explain docker container benefits over virtual machine setup (java jar as system process and installed nginx)
    // 1 Docker is lighter. Containers share operating systems whereas virtual machines are designed to emulate virtual hardware.
    // 2 Docker uses the Docker engine that resides over one Linux instance rather than the virtual resource intensive machines used by virtual machines.

    //todo E
    // Name and explain docker container drawback over virtual machine setup (java jar as system process and installed nginx)
    // 1 Security. Virtual machines offer more security against OS faults and security breaches than Docker
    // containers. The model of application separation that Docker uses to optimize resource usage comes at the cost of security.

    //todo F
    // Name and describe tools for docker architecture
    // 1 Docker Compose is a tool that lets you start multiple Docker containers together and configure how they interact.
    // 2 Dockerfile, docker build command builds a image from DockerFile and a context. he build’s context is the set
    // of files at a specified location PATH or URL. The PATH is a directory on your local filesystem.

    //todo G
    // Name and explain why are companies slow in moving existing systems to docker architecture (do not explain why docker is bad)
    // 1 long process to migrate to docker from virtual machines, time is money
    // 2 docker might be to new for the it landscape for older companies
}
