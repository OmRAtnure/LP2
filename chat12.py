# Practical 12
# Rule-Based Elementary Chatbot using Basic AI Techniques

def chatbot(user_input):

    rules = {
        "hello": "Hello! How can I help you today?",
        "hi": "Hi! Welcome to customer support.",
        "product": "We sell laptops, smartphones, and accessories.",
        "service": "We provide repair and maintenance services.",
        "price": "Prices depend on the selected product.",
        "delivery": "Delivery takes around 3-5 working days.",
        "bye": "Goodbye! Have a nice day."
    }

    for keyword in rules:
        if keyword in user_input:
            return rules[keyword]

    return "Sorry, I could not understand your query."


print("AI Chatbot Started")
print("Type 'exit' to stop\n")

while True:

    user = input("You: ").lower()

    if user == "exit":
        print("Bot: Chat ended.")
        break

    response = chatbot(user)
    print("Bot:", response)