import java.util.ArrayList;
import java.util.List;

public class PatternInterceptingFilter {
    public static void main(String[] args) {
        var chain = new FilterChain(new Target());
        chain.addFilter(new AuthenticationFilter());
        chain.addFilter(new LogFilter());

        var client = new Client();
        client.setFilterChain(chain);
        client.sendRequest("Downloading");
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

class Target {
    public void execute(String request) {
        System.out.println("Target executing " + request);
    }
}

class FilterChain {
    private List<Filter> filters = new ArrayList<>();
    private Target target;

    public FilterChain(Target target) {
        this.target = target;
    }

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public void execute(String request) {
        filters.stream().forEach(f -> f.apply(request));
        this.target.execute(request);
    }
}

class Client {
    private FilterChain chain;

    public void setFilterChain(FilterChain chain) {
        this.chain = chain;
    }
    public void sendRequest(String request) {
        System.out.println("Sending " + request + " request to target");
        this.chain.execute(request);
    }
}
