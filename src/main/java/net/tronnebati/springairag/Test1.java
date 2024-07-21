package net.tronnebati.springairag;

import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
//import org.springframework.ai.openai.OpenAiChatModel;
//import org.springframework.ai.openai.OpenAiChatOptions;
//import org.springframework.ai.openai.api.OpenAiApi;

import java.util.List;

public class Test1 {

    public static void main(String[] args) {

      /*  OpenAiApi openAiApi= new OpenAiApi("");
        OpenAiChatModel openAiChatModel = new OpenAiChatModel(openAiApi, OpenAiChatOptions.builder()
                .withModel("gpt-4o")
                .withTemperature(0F)
                .withMaxTokens(300)
                .build());
        String systemMessageText = """
                vous etes un assistant spécialisé dans le domaine de l'analyse de sentiment.
                votre taches est d'extraire à partir un commenataire le sentiment des différents aspects
                des ordinateurs achetés par des clients.les aspects qui nous sont intéressent sont : 
                l'écran, la souris et le clavier. Le sentiment peut etre négatif , positif ou neutre
                Le résultat attendu sera au format JSON avec les champs suivants :
                  - clavier : le sentiment relatif au clavier
                  - souris : le sentiment relatif à la souris
                  - ecran : le sentiment relatif àl'écran
                """;
        SystemMessage systemMessage = new SystemMessage(systemMessageText);

        String userInputText = """
                je suis satisfait par la qualité du l'écran,  
                  mais le clavier est mauvais, alors que pour la sourie, la qualité est plotot moyenne.
                  par ailleur je pense que cet ordinateur consome beaucoup de l'énergie
                """;

        UserMessage userMessage = new UserMessage(userInputText);

        String userInputText1 = """
                  je suis satisfait par la qualité du l'écran,  
                  mais le clavier est mauvais, alors que pour la sourie, la qualité est plotot moyenne.
                  par ailleur je pense que cet ordinateur consome beaucoup de l'énergie
                """;
        UserMessage userMessage1 = new UserMessage(userInputText1);

        String response1 = """
                { 
                   "clavier" : "negative",
                   "souris"  : "neutre",
                   "ecran"  : "positive"
                }
                """;
        AssistantMessage assistantMessage1 = new AssistantMessage(response1);


        Prompt ZeroShopPrompt = new Prompt(List.of(systemMessage,userMessage1,assistantMessage1,userMessage));
        ChatResponse chatResponse = openAiChatModel.call(ZeroShopPrompt);
        System.out.println(chatResponse.getResult().getOutput().getContent());

}

       */
    }

    }