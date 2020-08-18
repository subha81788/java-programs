public class PatternBuilderDemo {
    public static void main(String[] args) {
        Device device = new Device.DeviceBuilder("BETA1DELL10", Device.Model.BETA1).region("North America").timezone("EDT").gatewaySN("BETA1-GW").build();
        System.out.println(device);
    }
}

class Device {
    private String serial;
    private Model model;
    private String organization;
    private String region;
    private String timezone;
    private String gatewaySN;

    public Device(DeviceBuilder builder) {
        this.serial = builder.serial;
        this.model = builder.model;
        this.organization = builder.organization;
        this.region = builder.region;
        this.timezone = builder.timezone;
        this.gatewaySN = builder.gatewaySN;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Serial Number = " + this.serial 
                + "\tModel = " + this.model 
                + "\tOrganization = " + this.organization
                + "\tRegion = " + this.region 
                + "\tTimezone = " + this.timezone 
                + "\tGateway Serial Number = " + this.gatewaySN);
        return sb.toString();
    }

    public static class DeviceBuilder {
        private String serial;
        private Model model;
        private String organization;
        private String region;
        private String timezone;
        private String gatewaySN;

        public DeviceBuilder(String serial, Model model) {
            if(serial == null || model == null) {
                throw new IllegalArgumentException("Device Serial Number or Device Model cannot be null");
            }
            this.serial = serial;
            this.model = model;
        }

        public DeviceBuilder organization(String organization) {
            this.organization = organization;
            return this;
        }

        public DeviceBuilder region(String region) {
            this.region = region;
            return this;
        }

        public DeviceBuilder timezone(String timezone) {
            this.timezone = timezone;
            return this;
        }

        public DeviceBuilder gatewaySN(String gwSN) {
            this.gatewaySN = gwSN;
            return this;
        }

        public Device build() {
            return new Device(this);
        }
    }

    public enum Model {
        POWERSTORE, BETA1, BETA2
    }

}


/*
...
@Override
public Builder accept(String... types) {
    return getRequestBuilder().accept(types);
}
...

WebResource resource = Client.create().resource("http://myapp.org/api/v1/data");

WebResource.Builder builder = resource.accept(MediaType.APPLICATION_JSON);
builder.type(MediaType.APPLICATION_JSON);
builder.header(HttpHeaders.AUTHORIZATION, "Negotiate " + token);

return builder.get(String.class);

*/
