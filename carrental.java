import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.io.Serializable;

class Car implements Serializable
{
    private String model;
    private String brand;
    private int year;
    private int seatingCapacity;
    private double rentalRate;
    private boolean isAvailable;
    private boolean isDeleted;

    public Car(String model, String brand, int year, int seatingCapacity, int rentalRate, boolean isAvalaible) {
        this.model = model;
        this.brand = brand;
        this.year = year;

        this.seatingCapacity = seatingCapacity;
        this.rentalRate = rentalRate;
        this.isAvailable = isAvalaible;
    }
    
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }
    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
    public double getRentalRate() {
        return rentalRate;
    }
    public int getSeatingCapacity() {
        return seatingCapacity;
    }
    public int getYear() {
        return year;
    }
    public boolean getisavalible(){
        return isAvailable;
    }
    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}

class User implements Serializable
 {
    protected String name;
    protected String username;
    protected String password;

    public User() {
    }

    public User(String username, String password, String name)
    {
        this.name = name;
        this.username = username;
        this.password = password;   
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }
    public String getPassword() 
    {
        return password;
    }
    public void display() {
        System.out.println("Name is     : "+name);
        System.out.println("Username is : "+username);
        System.out.println("Password is : "+password);
    }
}

class CarInventory 
{
    public static List<Car> cars = new ArrayList<>();
    
    public CarInventory() 
    {

    }

    public static void addCar(Car car) 
    {
        cars.add(car);
    }

    public static void removeCar(Car car) 
    {
        cars.remove(car);
    }

    public static boolean checkAvailability(Car car)
    {
        return car.getisavalible();
    }

    public static List<Car> getAllCars() 
    {
        return cars;
    }

    public static void saveInventoryToFile(String fileName) 
    {
        try (FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) 
            {
            oos.writeObject(cars);
            } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

class Welcome
{
    public Welcome()
    {

    }

    public void firstgui()
    {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        panel.setLayout(null);

        JLabel mesg = new JLabel("Identify Your Identification");
        mesg.setBounds(100, 25, 350, 50);
        panel.add(mesg);

    
        JButton userButton = new JButton("User");
        userButton.setBounds(150, 150, 80, 30);
        userButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) 
            {
                Usermenue men = new Usermenue();
                men.usermenue();
            }
        });
        panel.add(userButton);
        frame.add(panel);
        frame.setVisible(true);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(150, 200, 80, 30);
        exitButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0);
            }
        });
        panel.add(exitButton);
        frame.add(panel);
        frame.setVisible(true);

    }
}

class Usermenue
 {
    public Usermenue()
    {

    }

    public void usermenue(){
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        panel.setLayout(null);

        JLabel mesg = new JLabel("WELCOME TO MY CAR Management SYSTEM");
        mesg.setBounds(80, 25, 350, 50);
        panel.add(mesg);

        JButton loginButton = new JButton("Login");
            loginButton.setBounds(150, 100, 80, 30);
            loginButton.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent e) 
                {
                    GUI log=new GUI();
                    log.gui();
                    
                }
            });
            panel.add(loginButton);
            frame.add(panel);
            frame.setVisible(true);

        

        JButton signupButton = new JButton("Sign Up");
        signupButton.setBounds(150, 150, 80, 30);
        signupButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) 
            {
                SignUp up = new SignUp();
                up.displaySignUp();
            }
        });
        panel.add(signupButton);
        frame.add(panel);
        frame.setVisible(true);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(150, 200, 80, 30);
        exitButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0);
            }
        });
        panel.add(exitButton);
        frame.add(panel);
        frame.setVisible(true);

    }
}

class SignUp 
{
    private JTextField usertext;
    private JPasswordField passwordtext;

    public SignUp()
    {

    }
    public void displaySignUp()
    {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        panel.setLayout(null);

        JLabel userlabel = new JLabel("Username:");
        userlabel.setBounds(10, 20, 80, 25);
        panel.add(userlabel);

        usertext = new JTextField();
        usertext.setBounds(100, 20, 165, 25);
        panel.add(usertext);

        JLabel passwordlabel = new JLabel("Password:");
        passwordlabel.setBounds(10, 50, 80, 25);
        panel.add(passwordlabel);

        JLabel label = new JLabel();
        label.setBounds(100, 80, 250, 125);
        panel.add(label);

        passwordtext = new JPasswordField();
        passwordtext.setBounds(100, 50, 165, 25);
        panel.add(passwordtext);

        
        JButton register = new JButton(" REGISTER");
        register.setBounds(10, 100,150, 25);
        register.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) 
            {
                try {
                    FileWriter fw = new FileWriter("userinventory.txt",true);
                    fw.write("\n"+usertext.getText()+","+passwordtext.getText());
                    fw.close();
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f,"Registration Completed");
                    GUI g=new GUI();
                    g.gui();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } 

            }
        });
        panel.add(register);
        frame.add(panel);
        frame.setVisible(true);
    }

}

class GUI 
{

    private JTextField usertext;
    private JPasswordField passwordtext;

    public GUI()
    {

    }
    public void gui()
    {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        panel.setLayout(null);

        JLabel userlabel = new JLabel("Username:");
        userlabel.setBounds(10, 20, 80, 25);
        panel.add(userlabel);

        usertext = new JTextField();
        usertext.setBounds(100, 20, 165, 25);
        panel.add(usertext);

        JLabel passwordlabel = new JLabel("Password:");
        passwordlabel.setBounds(10, 50, 80, 25);
        panel.add(passwordlabel);

        JLabel label = new JLabel();
        label.setBounds(100, 80, 250, 125);
        panel.add(label);

        passwordtext = new JPasswordField();
        passwordtext.setBounds(100, 50, 165, 25);
        panel.add(passwordtext);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 100, 80, 25);
        loginButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) 
            {
                
                String user_name = usertext.getText().toString();
                String pass_code = passwordtext.getText().toString();

                try 
                {
                    FileReader fil = new FileReader("userinventory.txt");
                    try (BufferedReader br = new BufferedReader(fil)) 
                    {
                            String line;
                            while((line=br.readLine())!=null)
                            {
                                if(line.equals(user_name+","+pass_code))
                                {
                                    label.setText("LOGIN SUCCESSFULLY");
                                    menue men = new menue();
                                    men.displaymenue();
                                }
                                else 
                                {
                                    label.setText("Invalid credentials");
                               }
                            }
                            fil.close();
                        }
                    } 
                    catch (FileNotFoundException e1) 
                    {
                        e1.printStackTrace();
                    }
                catch (IOException e2) 
                {
                    e2.printStackTrace();
                } 
               
            }
        });
        panel.add(loginButton);
        frame.add(panel);
        frame.setVisible(true);

        JButton backButton = new JButton("Back");
        backButton.setBounds(125, 100, 80, 25);
        backButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                Usermenue first=new Usermenue();
                first.usermenue();
            }
        });
        panel.add(backButton);
        frame.add(panel);
        frame.setVisible(true);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(225, 100, 80, 25);
        exitButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0);
            }
        });
        panel.add(exitButton);
        frame.add(panel);
        frame.setVisible(true);
        
    }
}

class menue
{
    public menue(){

    }

    public void displaymenue()
    {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(550, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        panel.setLayout(null);

        JLabel mesg = new JLabel("WELCOME TO MENUE");
        mesg.setBounds(200, 30, 200, 50);
        panel.add(mesg);

        JButton reservation_Button = new JButton("Make a Reservation");
        reservation_Button.setBounds(150, 100, 200, 30);
        reservation_Button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) 
            {
                Reservation res = new Reservation(); 
                res.Reservation_Process();
            }
        });
        panel.add(reservation_Button);
        frame.add(panel);
        frame.setVisible(true);


        JButton return_button = new JButton("Return a Car");
        return_button.setBounds(150, 150, 200, 30);
        return_button.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e)
            {
                Return_Car re = new Return_Car();
                re.ReturningCar();
            }
        });
        panel.add(return_button);
        frame.add(panel);
        frame.setVisible(true);

        JButton policy = new JButton("Policy of Company");
        policy.setBounds(150, 200, 200, 30);
        policy.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) 
            {

                Policy po = new Policy();
                po.policy();
            
            }
        });
        panel.add(policy);
        frame.add(panel);
        frame.setVisible(true);

        JButton logout = new JButton("Logout");
        logout.setBounds(150, 250, 200, 30);
        logout.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) 
            {
                Usermenue first=new Usermenue();
                first.usermenue();
            }
        });
        panel.add(logout);
        frame.add(panel);
        frame.setVisible(true);


        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(150, 300, 200,30);
        exitButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0);
            }
        });
        panel.add(exitButton);
        frame.add(panel);
        frame.setVisible(true);

    }
}

class Return_Car 
{
    private boolean found = false;
    private JTextArea policyText;

    public Return_Car() {

    }

    public void ReturningCar() {
        JFrame frame = new JFrame();
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel username_label = new JLabel("Enter your name:");
        username_label.setBounds(10, 25, 150, 25);
        panel.add(username_label);

        JTextField username = new JTextField();
        username.setBounds(175, 25, 165, 25);
        panel.add(username);

        JLabel CNIC_label = new JLabel("Enter your CNIC:");
        CNIC_label.setBounds(10, 75, 150, 25);
        panel.add(CNIC_label);

        JTextField cnic = new JTextField();
        cnic.setBounds(175, 75, 165, 25);
        panel.add(cnic);

        JButton back_Button = new JButton("Back");
        back_Button.setBounds(200, 125, 100, 30);
        back_Button.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) 
            {
                menue men=new menue();
                men.displaymenue();
            }
        });
        panel.add(back_Button);
        frame.add(panel);
        frame.setVisible(true);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(25, 125, 100, 30);
        searchButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String user_name = username.getText().trim();
                String CNIC = cnic.getText().trim();

                try (BufferedReader br = new BufferedReader(new FileReader("RESERVATIONHISTORY.txt"))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        if (line.equals(user_name)) {
                            String cnicLine = br.readLine();
                            String licenseLine = br.readLine();
                            String daysLine = br.readLine();
                            String modelLine = br.readLine();
                            String brandLine = br.readLine();
                            String yearLine = br.readLine();
                            String capacityLine = br.readLine();
                            String priceLine = br.readLine();

                            if (cnicLine.equals(CNIC)) {
                                found = true;

                                StringBuilder details = new StringBuilder();
                                details.append("Name: ").append(user_name).append("\n");
                                details.append("CNIC: ").append(cnicLine).append("\n");
                                details.append("License No: ").append(licenseLine).append("\n");
                                details.append("Days of Booking: ").append(daysLine).append("\n");
                                details.append("Car Model: ").append(modelLine).append("\n");
                                details.append("Car Brand: ").append(brandLine).append("\n");
                                details.append("Car Year: ").append(yearLine).append("\n");
                                details.append("Seating Capacity: ").append(capacityLine).append("\n");
                                details.append("Price per Day: ").append(priceLine).append("\n");

                                JFrame f = new JFrame();
                                JOptionPane.showMessageDialog(f, "WE HAVE FOUND YOUR RESERVATION.\n");
                                
                                JFrame frame = new JFrame();
                                frame.setSize(600, 450);
                                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        
                                JPanel panel = new JPanel();
                                panel.setLayout(null);
                        
                                policyText = new JTextArea();
                                policyText.setBounds(10, 20, 500, 250);
                                policyText.setEditable(false);
                                panel.add(policyText);
                        
                                policyText.setText( "\t\tThese are your Reservation Details \n\n" + details.toString());
                        
                                JButton backButton = new JButton("Back");
                                backButton.setBounds(25, 300, 100, 30);
                                backButton.addActionListener(new ActionListener() 
                                {
                                    public void actionPerformed(ActionEvent e) 
                                    {
                                        menue m = new menue();
                                        m.displaymenue();
                                    }
                                });
                                panel.add(backButton);
                                frame.add(panel);
                                frame.setVisible(true);
                        
                                JButton exitButton = new JButton("RETURN");
                                exitButton.setBounds(200, 300, 100, 30);
                                exitButton.addActionListener(new ActionListener() 
                                {
                                    public void actionPerformed(ActionEvent e) 
                                    {
                                        JFrame f = new JFrame();
                                        JOptionPane.showMessageDialog(f, "Pay your BILL first :\n");

                                        BILLPAYMENT bil = new BILLPAYMENT();
                                        bil.paybill(daysLine , priceLine, details,modelLine);
                                    }
                                });
                        
                                panel.add(exitButton);
                                frame.add(panel);
                                frame.setVisible(true);
                                break;

                            }
                        }
                    }

                    if (!found) {
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "NO reservation has been made against this name and CNIC.\nPlease try again!");
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        panel.add(searchButton);
        frame.add(panel);
        frame.setVisible(true);
    }

}

class BILLPAYMENT
{
    private JTextArea policyText;

    public BILLPAYMENT()
    {

    }

    public void paybill(String days,String price,StringBuilder details,String model)
    {
        JFrame frame = new JFrame();
        frame.setSize(500, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        policyText = new JTextArea();
        policyText.setBounds(10, 20, 400, 250);
        policyText.setEditable(false);
        panel.add(policyText);

        policyText.setText( "\t\tTHe BILL DETAILS ARE \n\n" + details.toString() + "\n\n\t\tTotal cost : "+(Integer.parseInt(days) * Double.parseDouble(price)));

        JButton payButton = new JButton("PAY");
        payButton.setBounds(250, 300, 80, 30);
        payButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                List<Car> cars = CarInventory.getAllCars();
        
                System.out.println("point 0");
        
                for (Car car :  cars)     
                {
                    System.out.println("point 1");
        
                    if (car.getModel().equalsIgnoreCase(model) && car.isDeleted()){
                        System.out.println("point 2");
                        car.setAvailable(true);
                        car.setDeleted(true);
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Succesfully Paid\n Thank tou for using our services.");
                    } 
                }
            }
        });

        panel.add(payButton);
        frame.add(panel);
        frame.setVisible(true);

        JButton signupButton = new JButton("Make another Reservation ");
        signupButton.setBounds(10, 300, 200, 30);
        signupButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) 
            {
                menue men = new menue();
                men.displaymenue();
            }
        });
        panel.add(signupButton);
        frame.add(panel);
        frame.setVisible(true);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(350, 300, 80, 30);
        exitButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0);
            }
        });
        panel.add(exitButton);
        frame.add(panel);
        frame.setVisible(true);
        
    }
}

class Reservation 
 {

    public Reservation(){


    }

    public void Reservation_Process()
    {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        panel.setLayout(null);

        JLabel mesg = new JLabel("Making a reservation.");
        mesg.setBounds(150, 30, 200, 25);
        panel.add(mesg);

        
        JButton avaliable_Button = new JButton("AVailable Cars");
        avaliable_Button .setBounds(100, 100, 200, 30);
        avaliable_Button .addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) 
            {
                Avalaible_Cars av = new Avalaible_Cars();
                av.Check_avalaibilty();
            }
        });
        panel.add(avaliable_Button );
        frame.add(panel);
        frame.setVisible(true);


        JButton search_button = new JButton("Search for a Car");
        search_button.setBounds(100, 150, 200, 30);
        search_button.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) 
            {
                Search_Cars search = new Search_Cars();
                search.carsearching();
            }
        });
        panel.add(search_button);
        frame.add(panel);
        frame.setVisible(true);

        JButton back_Button = new JButton("Back");
        back_Button.setBounds(50, 225, 100, 30);
        back_Button.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) 
            {
                menue men=new menue();
                men.displaymenue();
            }
        });
        panel.add(back_Button);
        frame.add(panel);
        frame.setVisible(true);


        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(220, 225, 100,30);
        exitButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0);
            }
        });
        panel.add(exitButton);
        frame.add(panel);
        frame.setVisible(true);

    }

}

class Search_Cars
{
    private JTextField usertext;

    public Search_Cars(){

    }

    public void carsearching() {
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);


        JLabel userlabel = new JLabel("Enter Car to search:");
        userlabel.setBounds(10, 100, 150, 25);
        panel.add(userlabel);

        usertext = new JTextField();
        usertext.setBounds(175, 100, 165, 25);
        panel.add(usertext);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(10, 175, 80, 30);
        submitButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                specifications specs =  new specifications();
                specs.specification(usertext);
            }
        });
        panel.add(submitButton);
        frame.add(panel);
        frame.setVisible(true);

        JButton backButton = new JButton("Back");
        backButton.setBounds(110, 175, 80, 30);
        backButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                Reservation res = new Reservation();
                res.Reservation_Process();
            }
        });
        panel.add(backButton);
        frame.add(panel);
        frame.setVisible(true);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(210, 175, 80, 30);
        exitButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0);
            }
        });
        panel.add(exitButton);
        frame.add(panel);
        frame.setVisible(true);
    }

    public JTextField getusertext(){
        return usertext;
    }
}

class Avalaible_Cars
 {
    private JTextArea policyText;
    private JTextField usertext;

    public Avalaible_Cars(){

    }

    public void Check_avalaibilty() {
        JFrame frame = new JFrame();
        frame.setSize(600, 725);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        policyText = new JTextArea();
        policyText.setBounds(10, 20, 450, 525);
        policyText.setEditable(false);
        panel.add(policyText);

        List<Car> cars = CarInventory.getAllCars();
        int count = 1;
 
        String data ="We have following avaliable cars. \n";
        policyText.append(data);

        for (Car car :  cars)
        {
            if (car.getisavalible()){
                
                data = count + ")  " + car.getModel() + "\n";
                policyText.append(data);
                count += 1;
            }
        }

        JLabel userlabel = new JLabel("Enter Car to reserve:");
        userlabel.setBounds(10, 570, 150, 25);
        panel.add(userlabel);

        usertext = new JTextField();
        usertext.setBounds(175, 570, 165, 25);
        panel.add(usertext);


        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(10, 620, 80, 30);
        submitButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                specifications spec= new specifications();
                spec.specification(usertext);
            }
        });
        panel.add(submitButton);
        frame.add(panel);
        frame.setVisible(true);

        JButton backButton = new JButton("Back");
        backButton.setBounds(110, 620, 80, 30);
        backButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                Reservation res = new Reservation();
                res.Reservation_Process();
            }
        });
        panel.add(backButton);
        frame.add(panel);
        frame.setVisible(true);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(210, 620, 80, 30);
        exitButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0);
            }
        });
        panel.add(exitButton);
        frame.add(panel);
        frame.setVisible(true);
    }

    public String getusertext(){
        return usertext.getText();
    }   
}

class specifications
{
    private JTextArea policyText;
    private boolean carFound = false ;

    public specifications()
    {

    }

    public void specification(JTextField model) {
        JFrame frame = new JFrame();
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        policyText = new JTextArea();
        policyText.setBounds(10, 20, 300, 150);
        policyText.setEditable(false);
        panel.add(policyText);

        List<Car> cars = CarInventory.getAllCars();
 
        
        for (Car car :  cars)
        {
            if (car.getModel().equalsIgnoreCase(model.getText())){
                policyText.append("This Car has following specifications : \n");
                policyText.append("Car Model: " + car.getModel() + "\n");
                policyText.append("Brand: " + car.getBrand() + "\n");
                policyText.append("Year: " + car.getYear() + "\n");
                policyText.append("Seating Capacity: " + car.getSeatingCapacity() + "\n");
                policyText.append("Rental Rate: " + car.getRentalRate() + "\n");
                policyText.append("\n");
                carFound = true;
               
            } 
            
        }   

        if (!carFound) {
            policyText.append("Sorry, we are unable to find this car:\n");
            policyText.append("Go back and try again\n");
            policyText.append("If you don't want to continue, exit");
        }
        
        if (carFound)
        {

            JButton submitButton = new JButton("Continue");
            submitButton.setBounds(10, 250, 100, 30);
            submitButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                user_information info = new user_information();
                info.userinformation(model.getText());
                }
            });

            panel.add(submitButton);
            frame.add(panel);
            frame.setVisible(true);
        }

        JButton backButton = new JButton("Change Car");
        backButton.setBounds(170, 250, 100, 30);
        backButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                Avalaible_Cars av = new Avalaible_Cars();
                av.Check_avalaibilty();
            }
        });
        panel.add(backButton);
        frame.add(panel);
        frame.setVisible(true);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(300, 250, 100, 30);
        exitButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0);
            }
        });
        panel.add(exitButton);

        frame.add(panel);
        frame.setVisible(true);
    }

}

class user_information 
{

    protected JTextField username;
    protected JTextField cnic;
    protected JTextField license_no;
    protected JTextField noofdays;

    public user_information(){

    }

    public void userinformation(String model)
    {
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel username_label = new JLabel("Enter your name :");
        username_label.setBounds(10, 25, 150, 25);
        panel.add(username_label);

        username = new JTextField();
        username.setBounds(175, 25, 165, 25);
        panel.add(username);

        JLabel CNIC_label = new JLabel("Enter your CNIC :");
        CNIC_label.setBounds(10, 75, 150, 25);
        panel.add(CNIC_label);

        cnic = new JTextField();
        cnic.setBounds(175, 75, 165, 25);
        panel.add(cnic);

        JLabel license = new JLabel("Enter your License NO:");
        license.setBounds(10, 125, 150, 25);
        panel.add(license);

        license_no = new JTextField();
        license_no.setBounds(175, 125, 165, 25);
        panel.add(license_no);

        JLabel days = new JLabel("Enter the Days :");
        days.setBounds(10, 175, 150, 25);
        panel.add(days);

        noofdays = new JTextField();
        noofdays.setBounds(175, 175, 165, 25);
        panel.add(noofdays);

        JFrame f = new JFrame();
        
        JButton submitButton = new JButton("Confirm Reservation");
        
        submitButton.setBounds(50, 225, 150, 30);
        submitButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                String enteredUsername = username.getText().trim();
                String enteredCnic = cnic.getText().trim();
                String enteredLicenseNo = license_no.getText().trim();
                String enteredNoOfDays = noofdays.getText().trim();

                if (enteredUsername.isEmpty() || enteredCnic.isEmpty() || enteredLicenseNo.isEmpty()
                        || enteredNoOfDays.isEmpty()) {
                    JOptionPane.showMessageDialog(f, "Please fill in all the fields.");
                    return; 
                }

                int noOfDays;
                try {
                    noOfDays = Integer.parseInt(enteredNoOfDays);
                    if (noOfDays <= 0) {
                        throw new NumberFormatException(); 
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(f, "Please enter a valid positive integer for 'Days'.");
                    return; 
                }


                List<Car> cars = CarInventory.getAllCars();

                for (Car car :  cars)
                {
                    System.out.println("Point 10");
                    if (car.getModel().equalsIgnoreCase(model)){ 
                        System.out.println("Point 0");

                        try (FileWriter fw = new FileWriter("RESERVATIONHISTORY.txt",true)) {
                            System.out.println("Point 3");

                            fw.write(username.getText()+"\n"+cnic.getText()+"\n"+license_no.getText()+"\n"+noofdays.getText()+
                            "\n" +car.getModel()+"\n"+car.getBrand() +"\n"+car.getYear() +"\n" +car.getSeatingCapacity()+"\n"+car.getRentalRate()+"\n\n");
                            fw.close();
                            car.setAvailable(false);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
                
                JOptionPane.showMessageDialog(f,"Reseervation Has been made.");
                Afterreservation after = new Afterreservation();
                after.reserving(model, enteredUsername, enteredCnic, enteredLicenseNo, enteredNoOfDays);
                
            }
        });
        panel.add(submitButton);
        frame.add(panel);
        frame.setVisible(true);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(225, 275, 100, 30);
        exitButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0);
            }
        });
        panel.add(exitButton);
        frame.add(panel);
        frame.setVisible(true);
    }

    protected String getusername(){
        return username.getText();
    }

    protected String getcnic(){
        return cnic.getText();
    }

    protected String getlicenseno(){
        return license_no.getText();
    }

    protected String getdays(){
        return noofdays.getText();
    }
}

class Afterreservation
{
    public Afterreservation()
    {

    }

    public void reserving(String model,String name,String cnic,String license, String days){
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        panel.setLayout(null);

        JButton loginButton = new JButton("Generate BILL");
        loginButton.setBounds(100, 50, 120, 40);
        loginButton.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent e) 
                {
                    Generate_Bill bill = new Generate_Bill(); 
                    bill.Bill(model,name ,cnic ,license ,days );       
                }
            });
        panel.add(loginButton);
        frame.add(panel);
        frame.setVisible(true);


      
                
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(100, 100, 120, 40);
        exitButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0);
            }
        });
        panel.add(exitButton);
        frame.add(panel);
        frame.setVisible(true);

    }
}

class Generate_Bill extends user_information
{
    private JTextArea policyText;
    private String policy;

    public Generate_Bill(){
        super();
     }

    public void Bill(String model,String name,String cnic,String license, String days)
    {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(550, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        panel.setLayout(null);

        policyText = new JTextArea();
        policyText.setBounds(10, 20, 500, 250);
        policyText.setEditable(false);
        panel.add(policyText);

        
        List<Car> cars = CarInventory.getAllCars();

        System.out.println("point 0");

        for (Car car :  cars)
        
        {
            System.out.println("point 1");
            
            System.out.println("car.getModel(): " + car.getModel());
            System.out.println("user_input: " + model);

            if (car.getModel().equalsIgnoreCase(model)){
                System.out.println("point 2");
                policy = "\n\t\t\tINVOICE:\n\n"
                + "Name       : "+ name +"\n"
                + "CNIC       : "+ cnic +"\n"
                + "License no : "+ license+"\n"
                + "Car Model  : "+ car.getModel()+ "\n"
                + "Car Brand  : "+ car.getBrand()+"\n"
                + "Car Year   : "+ car.getYear()+ "\n"
                + "Daily Price: "+ car.getRentalRate()+"\n"
                + "Your Days  : "+ days +"\n"
                + "\n\n\n"
                + "\t\t Total Bill :"+(Integer.parseInt(days) * car.getRentalRate() + "\n");
                car.setDeleted(true);
                
                break;
                }
            }

        policyText.setText(policy);
   

        JButton signupButton = new JButton("Make another Reservation ");
        signupButton.setBounds(200, 320, 200, 35);
        signupButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) 
            {
                menue men = new menue();
                men.displaymenue();
            }
        });
            
        

        panel.add(signupButton);
        frame.add(panel);
        frame.setVisible(true);



        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(50, 320, 100, 35);
        exitButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f,"\t\tTHANK YOU\n\tSEE YOU SOON ");

                System.exit(0);
            }
        });

        panel.add(exitButton);
        frame.add(panel);
        frame.setVisible(true);
    }
}

class Policy
{

    private JTextArea policyText;

    public Policy()
    {

    }

    public void policy(){
        JFrame frame = new JFrame();
        frame.setSize(600, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        policyText = new JTextArea();
        policyText.setBounds(10, 20, 500, 250);
        policyText.setEditable(false);
        panel.add(policyText);

        String policy = "\nCar Rental System Policy:\n\n"
                + "1. Only registered users can rent cars.\n"
                + "2. Valid identification and driver's license are required.\n"
                + "3. Cars must be returned on or before the specified return date.\n"
                + "4. Any damage to the car during the rental period will be the responsibility of the renter.\n"
                + "5. Late return may incur additional charges.\n"
                + "6. Smoking and pets are not allowed in the rented cars.\n"
                + "7. Any violation of traffic laws will be the responsibility of the renter.\n"
                + "8. Payment must be made in full before renting the car.\n"
                + "9. Reservation cancellations must be made at least 24 hours in advance.\n"
                + "10. Additional terms and conditions may apply.\n";

        policyText.setText(policy);

        JButton backButton = new JButton("Back");
        backButton.setBounds(25, 300, 100, 30);
        backButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                menue m = new menue();
                m.displaymenue();
            }
        });

        panel.add(backButton);
        frame.add(panel);
        frame.setVisible(true);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(200, 300, 100, 30);
        exitButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0);
            }
        });

        panel.add(exitButton);
        frame.add(panel);
        frame.setVisible(true);
        
    }
}

public class carrental {
    public static void main(String[] args) {

        Car car1 = new Car("Sonata", "Hyundai", 2018, 5, 6000, true);
        Car car2 = new Car("Corolla", "Toyota", 2018, 5, 5000, true);
        Car car3 = new Car("Civic", "Honda", 2019, 5, 5500, true);
        Car car4 = new Car("City", "Honda", 2020, 5, 6000, true);
        Car car5 = new Car("Cultus", "Suzuki", 2017, 5, 4000, true);
        Car car6 = new Car("Mehran", "Suzuki", 2019, 4, 3500, false);
        Car car7 = new Car("Camry", "Toyota", 2021, 5, 7500, true);
        Car car8 = new Car("Vitz", "Toyota", 2018, 5, 4500, true);
        Car car9 = new Car("Swift", "Suzuki", 2020, 4, 5500, false);
        Car car10 = new Car("i10", "Hyundai", 2019, 4, 5800, false);
        Car car11 = new Car("Picanto", "Kia", 2020, 4, 6200, true);
        Car car12 = new Car("Sunny", "Nissan", 2018, 5, 5200, false);
        Car car13 = new Car("Mira", "Daihatsu", 2019, 4, 4800, true);
        Car car14 = new Car("Ciaz", "Suzuki", 2020, 5, 6500, true);
        Car car15 = new Car("Alto", "Suzuki", 2021, 4, 4200, true);
        Car car16 = new Car("Wagon R", "Suzuki", 2019, 5, 3800, true);
        Car car17 = new Car("i20", "Hyundai", 2020, 5, 6700, true);
        Car car18 = new Car("Vento", "Volkswagen", 2018, 5, 6400, false);
        Car car19 = new Car("Yaris", "Toyota", 2020, 5, 5800, true);
        Car car20 = new Car("Celerio", "Suzuki", 2019, 4, 4700, true);
        Car car21 = new Car("S-Cross", "Maruti Suzuki", 2017, 5, 7200, false);
        Car car22 = new Car("Prius", "Toyota", 2020, 5, 8250, true);
        Car car23 = new Car("Aqua", "Toyota", 2018, 5, 6380, true);
        Car car24 = new Car("Figo", "Ford", 2019, 5, 5470, true);
        Car car25 = new Car("Lancer", "Mitsubishi", 2018, 5, 4650, false);
        Car car26 = new Car("Santro", "Hyundai", 2020, 5, 4930, true);
        Car car27 = new Car("Accent", "Hyundai", 2017, 5, 4800, true);
        Car car28 = new Car("EcoSport", "Ford", 2019, 5, 5500, true);
        Car car29 = new Car("S-Class", "Mercedes-Benz", 2020, 5, 10000, true);
        Car car30 = new Car("Pajero", "Mitsubishi", 2018, 7, 7000, true);
        
        CarInventory.addCar(car1);
        CarInventory.addCar(car2);
        CarInventory.addCar(car3);
        CarInventory.addCar(car4);
        CarInventory.addCar(car5);
        CarInventory.addCar(car6);
        CarInventory.addCar(car7);
        CarInventory.addCar(car8);
        CarInventory.addCar(car9);
        CarInventory.addCar(car10);
        CarInventory.addCar(car11);
        CarInventory.addCar(car12);
        CarInventory.addCar(car13);
        CarInventory.addCar(car14);
        CarInventory.addCar(car15);
        CarInventory.addCar(car16);
        CarInventory.addCar(car17);
        CarInventory.addCar(car18);
        CarInventory.addCar(car19);
        CarInventory.addCar(car20);
        CarInventory.addCar(car21);
        CarInventory.addCar(car22);
        CarInventory.addCar(car23);
        CarInventory.addCar(car24);
        CarInventory.addCar(car25);
        CarInventory.addCar(car26);
        CarInventory.addCar(car27);
        CarInventory.addCar(car28);
        CarInventory.addCar(car29);
        CarInventory.addCar(car30);
        
        CarInventory.saveInventoryToFile("CARINVENTORY.ser");
        
        Welcome wel = new Welcome();
        wel.firstgui();
    }
}