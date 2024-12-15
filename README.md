# DataPlotter - Dynamic CSV Data Visualization

## Project Overview

**DataPlotter** is a Java Spring-Boot web application that integrates with R through GraalVM to visualize data from a CSV file in real-time. The application reads numerical data from a specified column of the CSV file and dynamically plots it on a graph displayed in the browser. This project showcases integration between Java and R to handle and visualize large datasets.

## Features

- **CSV Parsing**: The application reads data from a provided CSV file (`swe307_pro1.csv`), where only one column of data is used for plotting.
- **Real-time Data Plotting**: The application reads one consecutive data value per second from the CSV file and sends it to an R function for plotting.
- **Dynamic Plot**: The plot is updated dynamically in the browser, with the x-axis representing time (0-99) and the y-axis representing the numerical values sent from the Java program.
- **R Integration**: The `xyplot()` function from the `lattice` library is used to create a line graph with a dark brown line and a grid.
- **Java Spring-Boot Backend**: The backend handles CSV reading, data processing, and communication with R to update the plot.

## How to Run

### Prerequisites

- **Java**: Make sure you have Java installed (Java 8 or higher).
- **Spring Boot**: The project uses Spring Boot for the backend. 
- **GraalVM**: GraalVM is required to execute the R function from Java.
- **R**: Install R and the `lattice` library for plotting.
- **CSV File**: The input file `swe307_pro1.csv` must be available in the correct directory.

### Running the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/DataPlotter.git
   cd DataPlotter
   ```

2. Install the necessary dependencies:
   ```bash
   mvn clean install
   ```

3. Start the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

4. The application will be accessible at `http://localhost:8080`. Open this URL in your web browser to see the dynamic plot.

### Plot Specifications

- **X-axis**: Integer values from 0 to 99, representing time.
- **Y-axis**: Values extracted from the selected column in the CSV file.
- **Plot Type**: Line plot with a dark brown line.
- **Grid**: A grid is included for better readability.

## Project Structure

```plaintext
DataPlotter/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   └── dataplotter/
│   │   │   │       ├── DataPlotterApplication.java   # Main Spring Boot application class
│   │   │   │       ├── CsvReader.java                # Reads data from CSV file
│   │   │   │       ├── RPlotService.java             # Handles R function integration
│   │   │   │       └── PlotController.java           # Manages web requests and responses
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/dataplotter/
│               └── DataPlotterApplicationTests.java  # Unit tests for the application
├── pom.xml  # Maven build configuration
└── README.md # Project documentation
```

## Conclusion

The **DataPlotter** project demonstrates how Java can be integrated with R to create dynamic data visualizations. This project allows users to visualize real-time data from a CSV file, providing a practical and interactive approach to handling and plotting large datasets.


