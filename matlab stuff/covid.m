data = readtable("data.csv");
rows = (categorical(data.countriesAndTerritories) == {'United_States_of_America'});
needed_data = data(rows,2:6);
x = 1:350;
y_cases = rows2vars(needed_data(:,4));
y_deaths = rows2vars(needed_data(:,5));
y_cases = flip(table2array(y_cases(:,2:351)));
y_deaths = flip(table2array(y_deaths(:,2:351)));

%plotting cases
plot(x(250:350),y_cases(250:350),'b')
title('Daily Covid Cases')
xlabel('Days Since January 1, 2020') 
ylabel('Covid Cases per Day') 

%prediction function for cases
fun = @(x,xdata)x(1)*exp(x(2)*xdata);
B = lsqcurvefit(fun,[0, 0],x(250:350),y_cases(250:350)-35000);
plot(x(250:350), y_cases(250:350), '.',x(250:350), B(1)*exp(B(2)*x(250:350))+35000);
title('Fitted Exponential Function (5.3861, 0.0303)')
xlabel('Days Since January 1, 2020') 
ylabel('Covid Cases') 

%plotting deaths
plot(x,y_deaths,'r')
title('United States Covid Deaths in 2020')
xlabel('Days Since January 1, 2020') 
ylabel('Covid Deaths')

%prediction function for cases
fun = @(x,xdata)x(1)*exp(x(2)*xdata);
B = lsqcurvefit(fun,[0, 0],x(250:350),y_deaths(250:350)-35000);
plot(x(250:350), y_deaths(250:350), '.',x(250:350), B(1)*exp(B(2)*x(250:350))+35000);
title('Fitted Exponential Function (5.3861, 0.0303)')
xlabel('Days Since January 1, 2020') 
ylabel('Covid Deaths') 