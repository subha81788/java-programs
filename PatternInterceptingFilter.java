import java.util.ArrayList;
import java.util.List;

public class PatternInterceptingFilter {
    public static void main(String[] args) {
        var target = new Target();

        var chain = new FilterChain();
        chain.addFilter(new AuthenticationFilter());
        chain.addFilter(new LogFilter());

        var client = new Client(target);
        client.setFilterChain(chain);
        client.sendRequest("Downloading");
    }
}

class Client {
    private Target target;
    private FilterChain chain;

    public Client(Target target) {
        this.target = target;
    }

    public void setFilterChain(FilterChain chain) {
        this.chain = chain;
        this.chain.setTarget(this.target);
    }

    public void sendRequest(String request) {
        System.out.println("Sending " + request + " request to target...");
        this.chain.doFilter(request);
    }
}

class Target {
    public void execute(String request) {
        System.out.println("Target executed " + request);
    }
}

class FilterChain {
    private Target target;
    private List<Filter> filters = new ArrayList<>();

    public void setTarget(Target target) {
        this.target = target;
    }

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public void doFilter(String request) {
        // this is an example of pre-filter
        System.out.println("Pre processing " + request + " request");
        filters.stream().forEach(f -> f.apply(request));
        // passes the request to target for actual execution
        this.target.execute(request);
    }
}

interface Filter {
    public void apply(String request);
}

class AuthenticationFilter implements Filter {
    @Override
    public void apply(String request) {
        System.out.println("Authenticating " + request);
    }
}

class LogFilter implements Filter {
    @Override
    public void apply(String request) {
        System.out.println("Logging " + request);
    }
}
