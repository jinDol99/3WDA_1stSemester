import os
import azure.cognitiveservices.speech as speechsdk

def recognize_from_microphone():
    # This example requires environment variables named "SPEECH_KEY" and "SPEECH_REGION"
    speech_config = speechsdk.SpeechConfig(subscription=os.environ.get('SPEECH_KEY'),
                                           region=os.environ.get('SPEECH_REGION'))
    speech_config.speech_recognition_language = "ko-KR"

    audio_config = speechsdk.audio.AudioConfig(use_default_microphone=True)
    speech_recognizer = speechsdk.SpeechRecognizer(speech_config=speech_config, audio_config=audio_config)

    print("Speak into your microphone.")
    speech_recognition_result = speech_recognizer.recognize_once_async().get()
    # str=speech_recognition_result.text
    if speech_recognition_result.reason == speechsdk.ResultReason.RecognizedSpeech:
        print("Recognized: {}".format(speech_recognition_result.text))
    elif speech_recognition_result.reason == speechsdk.ResultReason.NoMatch:
        print("No speech could be recognized: {}".format(speech_recognition_result.no_match_details))
    elif speech_recognition_result.reason == speechsdk.ResultReason.Canceled:
        cancellation_details = speech_recognition_result.cancellation_details
        print("Speech Recognition canceled: {}".format(cancellation_details.reason))
        if cancellation_details.reason == speechsdk.CancellationReason.Error:
            print("Error details: {}".format(cancellation_details.error_details))
            print("Did you set the speech resource key and region values?")

    command = speech_recognition_result.text

    #if "오케이 사연 댓글 읽어줘." in command and "Ok 사연 " in command:
    if "오케이 사연 댓글 읽어줘." in command or "Ok 사연 댓글 읽어줘." in command:
        # "좋아요 눌러줘"와 "ok사연" 문자열이 모두 포함된 경우 실행할 코드 작성
        text="댓글을 읽어드릴게요!"
    elif "오케이 사연 어플리케이션 열어줘." in command or "Ok 사연 어플리케이션 열어줘." in command:
        # "ok사연" 문자열만 포함된 경우 실행할 코드 작성
        text="오늘의 사연 어플리케이션을 열었습니다."
    elif "Ok 사연." in command:
        # "ok사연" 문자열만 포함된 경우 실행할 코드 작성
        text="네, 무엇을 도와드릴까요?"
    else:
        # 포함되지 않은 경우 실행할 코드 작성
        text="다시한번 말씀해주세요?"

    # This example requires environment variables named "SPEECH_KEY" and "SPEECH_REGION"
    speech_config = speechsdk.SpeechConfig(subscription=os.environ.get('SPEECH_KEY'),
                                           region=os.environ.get('SPEECH_REGION'))
    audio_config = speechsdk.audio.AudioOutputConfig(use_default_speaker=True)

    str = "ko-KR-BongJinNeural"

    # The language of the voice that speaks.
    speech_config.speech_synthesis_voice_name = str

    speech_synthesizer = speechsdk.SpeechSynthesizer(speech_config=speech_config, audio_config=audio_config)

    # Get text from the console and synthesize to the default speaker.


    speech_synthesis_result = speech_synthesizer.speak_text_async(text).get()

    if speech_synthesis_result.reason == speechsdk.ResultReason.SynthesizingAudioCompleted:
        print("Speech synthesized for text [{}]".format(text))
    elif speech_synthesis_result.reason == speechsdk.ResultReason.Canceled:
        cancellation_details = speech_synthesis_result.cancellation_details
        print("Speech synthesis canceled: {}".format(cancellation_details.reason))
        if cancellation_details.reason == speechsdk.CancellationReason.Error:
            if cancellation_details.error_details:
                print("Error details: {}".format(cancellation_details.error_details))
                print("Did you set the speech resource key and region values?")

recognize_from_microphone()


