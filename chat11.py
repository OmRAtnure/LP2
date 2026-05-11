# Practical 11
# Elementary Chatbot System for Customer Interaction

print("Welcome to Customer Support Chatbot")
print("Type 'exit' to end the chat\n")

while True:
    user = input("You: ").lower()

    if user == "exit":
        print("Bot: Thank you for visiting!")
        break

    elif "product" in user:
        print("Bot: We offer laptops, smartphones, and accessories.")

    elif "service" in user:
        print("Bot: We provide repair and maintenance services.")

    elif "price" in user:
        print("Bot: Prices vary depending on the product model.")

    elif "delivery" in user:
        print("Bot: Delivery usually takes 3-5 business days.")

    elif "faq" in user or "help" in user:
        print("Bot: You can ask about products, services, pricing, or delivery.")

    else:
        print("Bot: Sorry, I didn't understand your query.")