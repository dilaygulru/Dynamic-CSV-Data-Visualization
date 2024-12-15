library(lattice)

# Data array to store 100 values for y-axis
data <<- numeric(100)

function(dataHolder) {
    # Save plot as SVG
    svg()

    # Shift the data to the left and insert the new value from Java
    data <<- c(data[2:100], dataHolder$value)

    # X-axis will be integers from 0 to 99
    x_values <- 1:100

    # Create xyplot with y-values from the data and x-values from 0 to 99
    plot <- xyplot(data ~ x_values,
                   main='X-Y Plot from CSV Data',
                   xlab="X Axis (1-100)",
                   ylab="Y Axis (Values from CSV)",
                   type = c('l', 'g'), # Line plot with grid
                   col.line = '#5C4033') # Line color is dark brown

    # Print the plot to display it in the SVG
    print(plot)

    # Close the SVG device
    svg.off()
}