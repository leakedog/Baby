/// ebem etot mir
import java.text.DateFormat;
import java.util.*;

class Logic {
    ArrayList<Client> clients = null;
    ArrayList<Executor> executors = null;

    ArrayList<Order> orders = null;
    public class Client {
        private Integer id;
        private Description description;
        private Integer childrenNumber; /// how many need to be looked after
        private Side preferredSide;
        private String location;
        private Photo photo;
        private Rating rating;
        Client() {
            description = new Description();
            childrenNumber = 1;
            preferredSide = Side.BOTH;
            location = "";
            photo = new Photo();
            rating = calculate(this);
            if (clients == null) {
                clients = new ArrayList();
            }
            clients.add(this);
            id = clients.size();
        }

        Client(Integer id, Description description, Integer childrenNumber, Side preferredSide, String location) {
            this.id = id;
            this.description = description;
            this.childrenNumber = childrenNumber;
            this.preferredSide = preferredSide;
            this.location = location;
            this.rating = calculate(this);
            if (clients == null) {
                clients = new ArrayList();
            }
            clients.add(this);
            if (id == null) {
                id = clients.size();
            }
        }

        public Integer getId() {
            return id;
        }

        public Description getDescription() {
            return description;
        }

        public Integer getChildrenNumber() {
            return childrenNumber;
        }

        public Side getPreferredSide() {
            return preferredSide;
        }

        public String getLocation() {
            return location;
        }

        public Photo getPhoto() {
            return photo;
        }

        public Rating getRating() {
            return rating;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setDescription(Description description) {
            this.description = description;
        }

        public void setChildrenNumber(Integer childrenNumber) {
            this.childrenNumber = childrenNumber;
        }

        public void setPreferredSide(Side preferredSide) {
            this.preferredSide = preferredSide;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public void setPhoto(Photo photo) {
            this.photo = photo;
        }

        public void setRating(Rating rating) {
            this.rating = rating;
        }
    }
    private enum Side{
        CLIENTHOME,
        EXECUTORHOME,
        BOTH
    }
    public class Executor {
        private Integer id;
        private Description description;
        private Schedule schedule;
        private Integer price;
        private Photo photo;
        private Rating rating;
        private Side preferredSide;
        private String location;
        Executor() {
            description = new Description();
            location = "";
            price = 0;
            preferredSide = Side.BOTH;
            location = "";
            photo = new Photo();
            rating = calculate(this);
            if (executors == null) {
                executors = new ArrayList();
            }
            executors.add(this);
        }

        Executor(Integer id, Description description, Schedule schedule, Integer price, Photo photo, Side preferredSide, String location) {

            this.id = id;
            this.description = description;
            this.schedule = schedule;
            this.price = price;
            this.photo = photo;
            this.preferredSide = preferredSide;
            this.location = location;
            this.rating = calculate(this);
            if (executors == null) {
                executors = new ArrayList();
            }
            executors.add(this);
            id = executors.size();
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setDescription(Description description) {
            this.description = description;
        }

        public void setSchedule(Schedule schedule) {
            this.schedule = schedule;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public void setPhoto(Photo photo) {
            this.photo = photo;
        }

        public void setRating(Rating rating) {
            this.rating = rating;
        }

        public void setPreferredSide(Side preferredSide) {
            this.preferredSide = preferredSide;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public Side getPreferredSide() {
            return preferredSide;
        }

        public Photo getPhoto() {
            return photo;
        }

        public Rating getRating() {
            return rating;
        }

        public Integer getPrice() {
            return price;
        }

        public Schedule getSchedule() {
            return schedule;
        }

        public String getLocation() {
            return location;
        }

        public Description getDescription() {
            return description;
        }

        public Executor(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }
    }

    public class Order {
            \
        private Client client;
        private Executor executor;
        private DateFormat date;
        private Integer customerExperience;
        private Integer executorExperience;
    //    private Integer hours;
        Order(){}


        Order(Client client, Executor executor, DateFormat date, Integer customerExperience, Integer executorExperience/*, Integer hours*/){
            this.client = client;
            this.executor = executor;
            this.date = date;
            this.customerExperience = customerExperience;
            this.executorExperience = executorExperience;
       //     this.hours = hours;
        }

        public Client getClient(){
            return client;
        }
        public Executor getExecutor(){
            return executor;
        }
        public DateFormat getDate(){
            return date;
        }
        public int getCustomerExperience(){
            return customerExperience;
        }
        public int getExecutorExperience(){
            return executorExperience;
        }


        public void setExecutorExperience(Integer executorExperience) {
            this.executorExperience = executorExperience;
        }

        public void setCustomerExperience(Integer customerExperience) {
            this.customerExperience = customerExperience;
        }

        public void setDate(DateFormat date) {
            this.date = date;
        }

        public void setExecutor(Executor executor) {
            this.executor = executor;
        }

        public void setClient(Client client) {
            this.client = client;
        }
    }

    public class Rating {
        private double grade;
        private Integer numberOfOrders;

        public double getGrade(){
            return grade;
        }
        public int getNumberOfOrders(){
            return numberOfOrders;
        }
        public void setGrade(double value){
            grade = value;
        }
        public void setNumberOfOrders(int cnt){
            numberOfOrders = cnt;
        }

    }
    Rating calculate(Object element){
        Integer sum = 0;
        Integer cnt = 0;
        for(int i = 0; i < orders.size(); ++i){
            if(element == orders.get(i).getClient()) {
                sum += orders.get(i).getCustomerExperience();
                cnt ++;
            }
            if(element == orders.get(i).getExecutor()) {
                sum += orders.get(i).getExecutorExperience();
                cnt ++;
            }
        }
        Rating answer = new Rating();
        answer.setGrade((cnt == 0 ? 0 : (double)sum / (double)cnt));
        answer.setNumberOfOrders(cnt);
        return answer;
    }


    public class Schedule {

    }
    public class Description {
        private String text;
    }
    public class Photo {
        ///?
    }

}
