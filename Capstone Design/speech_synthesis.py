'''
  For more samples please visit https://github.com/Azure-Samples/cognitive-services-speech-sdk 
'''

import azure.cognitiveservices.speech as speechsdk

# Creates an instance of a speech config with specified subscription key and service region.
speech_key = "d68d535ddf964c41bd361c57c7eaec0b"
service_region = "koreacentral"

speech_config = speechsdk.SpeechConfig(subscription=speech_key, region=service_region)
# Note: the voice setting will not overwrite the voice element in input SSML.
# speech_config.speech_synthesis_voice_name = "ko-KR-YuJinNeural"

# Changes Voice 
print("Enter number for change voice. (male: 1~3 / female: 11~15) >")
voice = input()

if voice == "1":
    speech_config.speech_synthesis_voice_name = "ko-KR-BongJinNeural"
elif voice == "2":
    speech_config.speech_synthesis_voice_name = "ko-KR-GookMinNeural"
elif voice == "3":
    speech_config.speech_synthesis_voice_name = "ko-KR-InJoonNeural"
elif voice == "11":
    speech_config.speech_synthesis_voice_name = "ko-KR-JiMinNeural"
elif voice == "12":
    speech_config.speech_synthesis_voice_name = "ko-KR-SeoHyeonNeural"
elif voice == "13":
    speech_config.speech_synthesis_voice_name = "ko-KR-SoonBokNeural"
elif voice == "14":
    speech_config.speech_synthesis_voice_name = "ko-KR-SunHiNeural"
elif voice == "15":
    speech_config.speech_synthesis_voice_name = "ko-KR-YuJinNeural"
else:
    speech_config.speech_synthesis_voice_name = "ko-KR-BongJinNeural"
print(f'Setting voice to "{speech_config.speech_synthesis_voice_name}"\n')

# Get text from the console and synthesize to the default speaker.
print("Enter some text that you want to speak >")
text = input()

# use the default speaker as audio output.
speech_synthesizer = speechsdk.SpeechSynthesizer(speech_config=speech_config)

result = speech_synthesizer.speak_text_async(text).get()
# Check result
if result.reason == speechsdk.ResultReason.SynthesizingAudioCompleted:
    print("Speech synthesized for text [{}]".format(text))
elif result.reason == speechsdk.ResultReason.Canceled:
    cancellation_details = result.cancellation_details
    print("Speech synthesis canceled: {}".format(cancellation_details.reason))
    if cancellation_details.reason == speechsdk.CancellationReason.Error:
        print("Error details: {}".format(cancellation_details.error_details))

