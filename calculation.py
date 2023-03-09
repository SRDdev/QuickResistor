color_codes = {'black': 0, 'brown': 1, 'red': 2, 'orange': 3, 'yellow': 4, 'green': 5, 'blue': 6, 'violet': 7, 'gray': 8, 'white': 9}
Tolerance_codes = {"golden":5,"silver":10} 

def detect(band_colors):
    band1, band2, band3 = band_colors[:3]
    register_value = int(f'{color_codes[band1]}{color_codes[band2]}')
    multiplier = int(10**color_codes[band3])
    # tolerance = int(Tolerance_codes[tol])
    if(register_value >10 and 10**6>multiplier>=10**2):
        calculated = register_value*multiplier
        answer = calculated/10**2
        print(f"The value of Register is : {answer} Kohms")
    elif(register_value>10 and 10**9>multiplier>=10**6):
        calculated = register_value*multiplier
        answer = calculated/10**6
        print(f"The value of Register is : {answer} Mohms ")
    elif(register_value>10 and multiplier>=10**9):
        calculated = register_value*multiplier
        answer = calculated/10**9
        print(f"The value of Register is : {answer} Gohms")
    
# calculated = detect(['red', 'green', 'red',"silver"])

