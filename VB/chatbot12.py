print("Customer Chatbot")
print("Type 'exit' to stop")

while True:

    user = input("You: ").lower()

    if "hello" in user or "hi" in user:
        print("Bot: Hello! How can I help you?")

    elif "product" in user:
        print("Bot: We sell laptops, mobiles and headphones.")

    elif "service" in user:
        print("Bot: We provide free delivery and customer support.")

    elif "price" in user:
        print("Bot: Prices start from 5000 rupees.")

    elif "contact" in user:
        print("Bot: You can contact us at support@gmail.com")

    elif "thanks" in user:
        print("Bot: Welcome!")

    elif "exit" in user:
        print("Bot: Thank you for visiting.")
        break

    else:
        print("Bot: Sorry, I cannot understand your query.")