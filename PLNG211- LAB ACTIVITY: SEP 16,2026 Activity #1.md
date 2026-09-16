while True:
    user_input = input("\nEnter USD prices (separated by commas) or 'exit': ").strip().lower()
    
    if user_input == 'exit':
        break
        
    try:
        usd_prices = [float(p.strip()) for p in user_input.split(",") if p.strip()]
        euro_prices = [round(price * exchange_rate, 2) for price in usd_prices]
        print("Euro prices:", euro_prices)
    except ValueError:
        print("Please enter numbers only.")
