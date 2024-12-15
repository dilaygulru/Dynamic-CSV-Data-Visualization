library(lattice)

data <<- numeric(100)

function(dataHolder) {

    svg()

    data <<- c(data[2:100], dataHolder$value)

    x_values <- 1:100

    plot <- xyplot(data ~ x_values,
                   main='X-Y Plot from CSV Data',
                   xlab="X Axis (1-100)",
                   ylab="Y Axis (Values from CSV)",
                   type = c('l', 'g'), # Line plot with grid
                   col.line = '#5C4033') # Line color is dark brown

    print(plot)

    svg.off()
}