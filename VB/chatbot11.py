print("Simple Customer Chatbot")
print("Type 'bye' to exit")

while True:

    user = input("You: ").lower()

    if "product" in user:
        print("Bot: We provide laptops, mobiles and accessories.")

    elif "service" in user:
        print("Bot: We provide 24/7 customer support and free delivery.")

    elif "price" in user:
        print("Bot: Prices start from 5000 rupees.")

    elif "contact" in user:
        print("Bot: Contact us at support@gmail.com")

    elif "faq" in user:
        print("Bot: Frequently asked questions are available on our website.")

    elif "bye" in user:
        print("Bot: Thank you for visiting.")
        break

    else:
        print("Bot: Sorry, I did not understand.")